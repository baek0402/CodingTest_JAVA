package algo0903;

import java.util.*;
import java.io.*;

public class boj1920 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 1 2 3 4 5 정렬
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		int[] myArr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			myArr[i] = Integer.parseInt(st.nextToken());
		} // 1 3 5 7 9 정렬
		//Arrays.sort(myArr);
		
		//1. 이분탐색
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			//index
			int start = 0;
			int end = N-1;
			int target = myArr[i]; //찾으려는 값
			
			for(int j = 0; j < N; j++) {
				int mid = (start + end) / 2;
				
				if(target > arr[mid]) {
					start = mid + 1;
				}
				else if(target < arr[mid]) {
					end = mid - 1;
				}
				else {
					sb.append(1 + "\n");
					break;
				}
				
				if(start > end) {// 로 수정해야합니당..
					sb.append(0 + "\n");
					break;
				}
					
			}
		}
		System.out.println(sb);
	}

}
