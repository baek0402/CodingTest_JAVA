package algo0706;

import java.io.*;
import java.util.*;

public class boj10816 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//map, set, list
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Map<Integer, Integer> m = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int t = Integer.parseInt(st.nextToken());
			
			if(!m.containsKey(t)) {
				m.put(t, 1);
			} else {
				m.put(t, m.get(t)+1);
			}
			//6 3 2 10 10 10 -10 -10 7 3
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int t = Integer.parseInt(st.nextToken());
			
			if(!m.containsKey(t)) {
				sb.append(0 + " ");
			} else {
				sb.append(m.get(t) + " ");
			}
		}
		System.out.println(sb);
	}

}
