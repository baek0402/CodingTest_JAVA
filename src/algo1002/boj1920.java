package algo1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 1 2 3 4 5
		
		int M = Integer.parseInt(br.readLine());
		int[] ans = new int[M];
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int start = 0;
			int end = N-1;
			int mid = 0;
			
			int num = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < N; j++) {
				mid = (start + end) / 2;
				
				if(num > arr[mid])
					start = mid+1;
				else if(num < arr[mid])
					end = mid-1;
				else {
					sb.append(1).append("\n");
					break;
				}
				
				if(start > end) {
					sb.append(0).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}

}
