package algo0718;

import java.util.*;
import java.io.*;

public class boj1697 {

	static int n;
	static int k;
	static int cnt = 0;
	static int dist[];
	static boolean visited[];
	// static int dx[] = {x+1, x-1, 2*x};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dist = new int[100001]; //100001
		visited = new boolean[100001];
		
		bfs(n);
		System.out.println(dist[k]);
	}
	
	static void bfs(int st) {		
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(st);
		visited[st] = true;
		
		int nx = 0;

		while(!que.isEmpty()) {
			int now = que.poll();
			
			if(now == k) {
				break;
			}
			
			//now+1, now-1, now*2
			if(now+1 <= 100000 && dist[now+1] == 0) {
				nx = now + 1;
				que.offer(nx);
				
				visited[nx] = true;
				dist[nx] = dist[now]+1;
			}
			if(now-1 >= 0 && dist[now-1] == 0) {
				nx = now - 1;
				que.offer(nx);

				visited[nx] = true;
				dist[nx] = dist[now]+1;
			}
			if(now*2 <= 100000 && dist[now*2] == 0) {
				nx = now * 2;
				que.offer(nx);

				visited[nx] = true;
				dist[nx] = dist[now]+1;
			}
		}
		
	}

}
