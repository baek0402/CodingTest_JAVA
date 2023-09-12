package algo0911;

import java.util.*;
import java.io.*;

public class boj5427 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());		
		
		while(tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			boolean flag = false;
			char[][] board = new char[N][M];
			boolean[][] visited = new boolean[N][M];
			
			int[][] fire_dist = new int[N][M];
			int[][] sang_dist = new int[N][M];

			Queue<int[]> sang = new ArrayDeque<>();
			Queue<int[]> fire = new ArrayDeque<>();
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < M; j++) {
					board[i][j] = str.charAt(j); // ####
					fire_dist[i][j] = -1;
					sang_dist[i][j] = -1;
					
					if(board[i][j] == '@') {//상근이 시작 위치
						sang.offer(new int[] {i, j});
						sang_dist[i][j] = 0;
					}
					if(board[i][j] == '*') {
						fire.offer(new int[] {i, j});
						fire_dist[i][j] = 0;
					}
				}
			}
			
			//불 영역
			while(!fire.isEmpty()) {
				int[] now = fire.poll();
								
				for(int dir = 0; dir < 4; dir++) {
					int nx = now[0] + dx[dir];
					int ny = now[1] + dy[dir];
					
					if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
					if(fire_dist[nx][ny] != -1 || board[nx][ny] == '#') continue;
					
					fire.offer(new int[] {nx, ny});
					fire_dist[nx][ny] = fire_dist[now[0]][now[1]]+1;
				}
			}
			//불이 스쳐지나간 시간이 기록 됨
			
			/*
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					System.out.print(fire_dist[i][j] + " ");
				}
				System.out.println();
			}
			*/
			
			//상근이 영역
			while(!sang.isEmpty() && !flag) {
				int[] now = sang.poll();
							
				for(int dir = 0; dir < 4; dir++) {
					int nx = now[0] + dx[dir];
					int ny = now[1] + dy[dir];
				
					if(nx >= N || nx < 0 || ny >= M || ny < 0) {
						flag = true;
						System.out.println(sang_dist[now[0]][now[1]]+1);
						break;
					}
					if(sang_dist[nx][ny] != -1 || board[nx][ny] == '#') continue;
					//if(sang_dist[now[0]][now[1]] >= fire_dist[now[0]][now[1]]) continue;
					if(sang_dist[now[0]][now[1]]+1 >= fire_dist[nx][ny] && fire_dist[nx][ny] != -1) continue;
					
					sang_dist[nx][ny] = sang_dist[now[0]][now[1]] + 1;
					sang.offer(new int[] {nx, ny});
				}
			}
			
			//1. 고려하지못한점 flag가 false일동안만 도는거랑
			//2. 두번째 조건문인데 저건 왜지? 하 ㅜ
			
			/*for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					System.out.print(sang_dist[i][j] + " ");
				}
				System.out.println();
			}*/
			
			if(!flag)
				System.out.println("IMPOSSIBLE");
		}
	}
}
