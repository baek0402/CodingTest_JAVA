package algo0928;

import java.util.*;
import java.io.*;

public class boj1697 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[100005];
		boolean[] visited = new boolean[100005];
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(N);
		
		//x-1, x+1, 2*x
		while(!que.isEmpty()) {
			int num = que.poll(); //½ÃÀÛÁ¡
			if(num == M) break;
			
			if(num-1 >= 0 && !visited[num-1]) {
				visited[num-1] = true;
				que.offer(num-1);
				arr[num-1] = arr[num]+1;
			}
			if(num+1 <= 100000 && !visited[num+1]) {
				visited[num+1] = true;
				que.offer(num+1);
				arr[num+1] = arr[num]+1;
			}
			if(num*2 <= 100000 && !visited[num*2]) {
				visited[num*2] = true;
				que.offer(num*2);
				arr[num*2] = arr[num]+1;
			}
		}
		
		System.out.println(arr[M]);
	}

}
