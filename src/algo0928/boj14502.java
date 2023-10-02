package algo0928;

import java.util.*;
import java.io.*;

public class boj14502 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static int[][] area;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		area = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {				
				int num = Integer.parseInt(st.nextToken());
				area[i][j] = num;
			}
		}
		
		/*StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(area[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		*/
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && area[i][j] == 2) {
					bfs(i, j);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(area[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		int answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(area[i][j] == 0) answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();

			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(visited[nx][ny] || area[nx][ny] == 1) continue; //벽이고 이미 들렀으면
				
				area[nx][ny] = 2; //바이러스퍼뜨려!
				visited[nx][ny] = true;
				que.offer(new int[] {nx, ny});
			}
		}
	}

}
