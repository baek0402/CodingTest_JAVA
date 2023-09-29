package algo0928;

import java.util.*;
import java.io.*;

public class boj1260 {
	static boolean[] visited;
	static int[][] board;
	static int[] ans1;
	static int[] ans2;
	static int N;
	static int M;
	static int s;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		sb = new StringBuilder();
		visited = new boolean[N+1];
		board = new int[N+1][N+1]; //1~4
		ans1 = new int[N];
		ans2 = new int[N];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			board[a][b] = 1;
			board[b][a] = 1; //연결되어있다는 표시인겨
		}
		//dfs
		dfs(s);
		sb.append("\n");
		
		//bfs
		bfs(s);
		
		System.out.println(sb);
	}
	public static void dfs(int start) {
		/*if(depth == N) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				sb.append(ans1[i]).append(" ");
			}
			System.out.println(sb);
			return;
		}*/
		visited[start] = true;
		sb.append(start).append(" ");
		
		for(int i = 1; i <= N; i++) {
			//System.out.println(0);
			if(!visited[i] && board[start][i] == 1) {
				dfs(i);
			}
		}
	}
	public static void bfs(int start) {
		visited = new boolean[N+1];
		Queue<Integer> que = new ArrayDeque<>();
		
		que.offer(start); //
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int num = que.poll();//1
			sb.append(num).append(" ");
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && board[num][i] == 1) {				
					que.offer(i);
					visited[i] = true; //2, 3, 4
				}
			}
		}
	}

}
