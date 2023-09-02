package algo0626;

import java.util.*;
import java.io.*;

public class boj11279 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //최대 힙(내림차순)
		StringBuilder sb = new StringBuilder();
		while(tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			if(n != 0) {
				pq.offer(n);
			}
			else {
				if(pq.isEmpty()) {
					sb.append(0 + "\n");
				}
				else {
					sb.append(pq.poll() + "\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
