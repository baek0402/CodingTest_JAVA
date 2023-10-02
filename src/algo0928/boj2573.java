package algo0928;

import java.io.*;
import java.util.*;

public class boj2573 {
	static int N;
	static int M;
	static boolean[][] visited;
	static int[][] area;
	static int[][] changed;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		area = new int[N][M];
		changed = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		int year = 0;
		while(true) {			
			year = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(!visited[i][j] && area[i][j] != 0) {
						visited[i][j] = true;
						bfs(i, j);
						year++;
					}
				}
			}
			if(year >= 2) break;
			else if(year == 0) {
				System.out.println(0);
				return;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					area[i][j] = changed[i][j];
					visited[i][j] = false;
				}
			}
			answer++;
		}
		System.out.println(answer);
	}
	public static void bfs(int x, int y) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {x, y});
		
		while(!que.isEmpty()) {
			int cnt = 0;
			int[] now = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 ||  ny >= M) continue;
				if(area[nx][ny] == 0) cnt++;
				if(visited[nx][ny] || area[nx][ny] <= 0) continue;
				
				que.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
			int changed_land = area[now[0]][now[1]] - cnt;
			if(changed_land < 0) changed_land = 0;
			changed[now[0]][now[1]] = changed_land;
			//System.out.println("zz");
		}
	}

}
