package algo1002;

import java.io.*;
import java.util.*;

public class boj2805 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int sum = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); //오름차순
		int start = arr[0];
		int end = arr[N-1];
		int mid = 0;
		
		while(start < end) {
			long value = 0;
			mid = (start + end) / 2;
			
			//mid값과 구하려는 값 비교
			for(int i = 0; i < N; i++) {
				if(arr[i] > mid) {
					value += arr[i] - mid;
				}
			}
			
			if(value > M ) {
				start = mid;
			}
			else if(value < M) {
				end = mid - 1;
			}
			else {
				System.out.println(mid);
				return;
			}
		}
		System.out.println(start - 1); //제일큰값이니까?...
	}

}
