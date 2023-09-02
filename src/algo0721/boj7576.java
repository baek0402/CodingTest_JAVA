package algo0721;

import java.io.*;
import java.util.*;

public class boj7576 {
	
	static int n, m;
	static int mat[][];
	static int dist[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static int cnt = 0;
	
	static Queue<int[]> que;
	
	public static void main (String[] args) throws IOException {
		// 출발점이 여러개인 경우
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		mat = new int[n][m];
		dist = new int[n][m];
		
		que = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				
				if(mat[i][j] == 1) {
					//dist[i][j] = 1;	
					que.offer(new int[] {i, j});
				}
			}
		}
		
		bfs();
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(mat[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				answer = Math.max(mat[i][j], answer);
			}
		}
		System.out.println(answer-1);
		//-1을 해주는 이유는 거리 시작을 1부터 잡았기 때문!
		
	}
	
	static void bfs() {
		
		while(!que.isEmpty()) {
			int now[] = que.poll();
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = now[0] + dx[dir];
				int ny = now[1] + dy[dir];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if(mat[nx][ny] != 0) continue;
				
				mat[nx][ny] = mat[now[0]][now[1]] + 1;
				que.offer(new int[] {nx, ny});
				//cnt++;
				
				//탈출조건.. 다 채워지면.. 나오는건데
			}
		}
	}
}
