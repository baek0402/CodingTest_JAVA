package algo0619;

import java.util.*;
import java.io.*;

public class boj13417 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t < tc; t++) {
			StringBuilder sb = new StringBuilder();
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Deque<String> dq = new ArrayDeque<>();
			for(int i=0; i < N; i++) {
				String s = st.nextToken();
				if(i == 0) dq.offer(s); 
				else {
					if(dq.peek().compareTo(s) >= 0) {//오름차순
						dq.offerFirst(s);
					}
					else {
						dq.offerLast(s);
					}
				}			
			}
			
			
			while(!dq.isEmpty()){
               sb.append(dq.pollFirst());
            }
            sb.append("\n");
			
			
//			for(int i=0; i < N; i++)
//				sb.append(dq.poll());
			System.out.println(sb.toString());
		}
	}
}
