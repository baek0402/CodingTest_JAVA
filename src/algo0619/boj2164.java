package algo0619;

import java.io.*;
import java.util.*;

public class boj2164 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> qu = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			qu.offer(i);
		}
		
		while(qu.size() > 1) {
			qu.poll();
			qu.offer(qu.poll());
		}
		System.out.println(qu.peek());
	}

}
