package algo0928;

import java.util.*;
import java.io.*;

public class boj2606 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] board = new int[N+1][N+1]; //1~7
		boolean[] visited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			board[a][b] = 1;
			board[b][a] = 1;
		}
		
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(1);
		
		int answer = 0;
		while(!que.isEmpty()) {
			int num = que.poll();
			visited[num] = true;
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && board[num][i] == 1) {
					answer++;
					que.offer(i);
					//visited[i] = true;
				}
			}
		}
		
		System.out.println(answer);
	}

}
