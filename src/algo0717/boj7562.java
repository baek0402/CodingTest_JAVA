package algo0717;

import java.io.*;
import java.util.*;

public class boj7562 {

	static int mat[][];
	static boolean visited[][];
	static int dx[] = {-2, -1, 1, 2, 1, 2, -2, -1};
	static int dy[] = {1, 2, 2, 1, -2, -1, -1, -2};
	
	static int n;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st;
		while(tc-- > 0) {
			cnt = 0;
			n = Integer.parseInt(br.readLine()); // n*n

			mat = new int[n][n];
			visited = new boolean[n][n];
			
			st = new StringTokenizer(br.readLine());
			int stX = Integer.parseInt(st.nextToken());
			int stY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int destX = Integer.parseInt(st.nextToken());
			int destY = Integer.parseInt(st.nextToken());
			
			dfs(stX, stY, destX, destY);
			System.out.println(mat[destX][destY]);
		}
	}
	
	static void dfs(int x, int y, int destX, int destY) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!que.isEmpty()) {			
			int now[] = que.poll();
			if(now[0] == destX && now[1] == destY) return;
			
			for(int i = 0; i < 8; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny])
					continue;
				
				visited[nx][ny] = true;
				mat[nx][ny] = mat[now[0]][now[1]] + 1;
				que.offer(new int[] {nx, ny});
			}
		}

	}

}
