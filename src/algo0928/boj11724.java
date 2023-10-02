package algo0928;

import java.util.*;
import java.io.*;

public class boj11724 {
	
	static int N;
	static int M;
	static int[][] board;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			board[a][b] = 1;
			board[b][a] = 1;
		}
		
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				bfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	public static void bfs(int start) {
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(start); //Ω√¿€¿∫ 1
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int num = que.poll();
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && board[num][i] == 1) {
					que.offer(i);
					visited[i] = true;
				}
			}
		}
	}

}
