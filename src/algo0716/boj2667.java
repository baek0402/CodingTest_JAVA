package algo0716;

import java.util.*;
import java.io.*;

public class boj2667 {

	static int arr[][];
	static boolean visited[][];
	static int area[];
	static int cnt;
	static int N;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		visited = new boolean[N][N];
		area = new int[N*N];
		cnt = 0;
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		
		sb.append(cnt).append("\n");
		Arrays.sort(area);
		for(int i = 0; i < area.length; i++) {
			if(area[i] > 0)
				sb.append(area[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		area[cnt] += 1;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if(arr[nx][ny] == 0 || visited[nx][ny])
				continue;
			
			dfs(nx, ny);
		}		
	}

	
}
