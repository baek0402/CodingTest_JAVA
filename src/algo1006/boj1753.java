package algo1006;

import java.io.*;
import java.util.*;

public class boj1753 {
	static List<int[]> al[];
	static int[] d;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); //정점의 개수
		int E = Integer.parseInt(st.nextToken()); //간선의 개수
		int start = Integer.parseInt(br.readLine());
		
		d = new int[V+1];
		al = new ArrayList[V+1]; //int배열을 가지는 List타입의 al배열		
		for(int i = 1; i <= V; i++) {
			al[i] = new ArrayList<>();
		} //초기화
		
		for(int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int vl = Integer.parseInt(st.nextToken());
			
			al[a].add(new int[] {b, vl}); //5->1, 1
		}
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start] = 0;
		
		find(start);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(d[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(d[i]).append("\n");
		}
		System.out.println(sb);
	}
	static void find(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] > o2[1]) return 1;
				else if(o1[1] < o2[1]) return -1;
				else return 0;				
			}
		}); //오름차순인데
		
		pq.offer(new int[] {start, 0});
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			
			for(int[] next : al[now[0]]) {
				if(d[next[0]] > now[1] + next[1]) {
					d[next[0]] = now[1] + next[1];
					pq.offer(new int[] {next[0], d[next[0]]});
				}
			}
		}
	}
}
