package algo0626;

import java.util.*;
import java.io.*;

public class boj1927 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		while(tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				if(pq.isEmpty()) {
					sb.append(0 + "\n");
				}
				else {
					sb.append(pq.poll() + "\n");
				}
			}
			else {
				pq.offer(n);
			}
		}
		System.out.println(sb.toString());
	}

}
