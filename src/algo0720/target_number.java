package algo0720;

import java.io.*;
import java.util.*;

public class target_number {

	static int n, t;
	static int num[];
	static int arr[];
	static boolean visited[];
	static char calc[] = {'+', '-'};
	static int sum = 0;
	static int cnt = 0;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 5
		t = Integer.parseInt(br.readLine()); // 3
		
		num = new int[n];
		arr = new int[n];
		visited = new boolean[n]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		System.out.println(cnt);
	}
	
	static void dfs(int depth, int idx) {
		
		//sum 
		if(depth != 0) {
			if(calc[idx] == '+') {
				sum = sum + num[depth-1];
				System.out.print(+1);
				//System.out.println(+1);
			}
			else if(calc[idx] == '-') {
				sum -= num[depth-1];
				sb.append(-1);
				System.out.print(-1);
			}
		}
		
		if(depth == n) {
			System.out.println(sum);
			if(sum == t) {
				cnt++;
			}
			//방금계산한값을 빼야지 (더했으면 빼고 뻈으면 더하고..)
			
			return;
		}
		
		for(int i = 0; i < 2; i++) {
			dfs(depth+1, i);
			if(calc[i] == '+') sum -= num[depth];
			else if(calc[i] == '-') sum += num[depth];
			
		}
	}

}
