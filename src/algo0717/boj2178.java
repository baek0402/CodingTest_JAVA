package algo0717;

import java.io.*;
import java.util.*;

public class boj2178 {

	static int N, M;
	static int mat[][];
	static boolean visited[][];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				mat[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		
		System.out.println(mat[N-1][M-1]);		
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int[] now = que.poll(); //
			
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M ||
						mat[nx][ny] == 0 || visited[nx][ny]) {
					continue;
				}
				
				que.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
				
				//dist라는 배열을 추가해줄 수도 있지만 그냥 기존의 mat배열을 이용
				mat[nx][ny] = mat[now[0]][now[1]] + 1;	
			}
		}
	}

}
