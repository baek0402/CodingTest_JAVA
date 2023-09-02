package algo0620;

import java.util.*;
import java.io.*;

public class boj1966 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		/*
		 * 4 2
		 * 1 2 3 4
		 */
		
		
		while(tc-- > 0) {
			Queue<Integer> q1 = new ArrayDeque<>(); // 5
			Queue<Integer> q2 = new ArrayDeque<>(); // 1
			Queue<Integer> sortQ = new ArrayDeque<>();
			int cnt = 1;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //4
			int M = Integer.parseInt(st.nextToken()); //2 
			
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				q1.offer(arr[i]);
				if(i == M) q2.offer(1);
				else q2.offer(0);
				
				// 1234
				// 0010
				// 4321
			}
			Arrays.sort(arr); //111119
			for(int i = N-1; i >= 0; i--) sortQ.offer(arr[i]);
			
//			System.out.println(q1.peek() + " " + q2.peek() + " " + sortQ.peek());
			
			// 6 0 
			// 100000 q2
			// 119111 q1			
			// 911111 sortQ
			
			while(true) {
				if(q1.peek() < sortQ.peek()) {
					q1.offer(q1.poll()); // 191111 -> 911111
					q2.offer(q2.poll()); // 100000 -> 000001
				}
				else if(q1.peek() == sortQ.peek()) {
					if(q2.peek() == 1) {
						System.out.println(cnt);
						break;
					}
					
					// 000001 -> 0001
					// 911111 -> 1111
					// 911111 -> 1111
					q1.poll();
					q2.poll();
					sortQ.poll();
					cnt++;					
				}
			}

		}
	}

}
