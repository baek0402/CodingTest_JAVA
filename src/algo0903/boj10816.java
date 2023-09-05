package algo0903;

import java.util.*;
import java.io.*;

public class boj10816 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] len = new int[N];
		for(int i = 0; i < N; i++) {
			len[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(len);
		
		//젤 큰 값 기준으로 이분법을 시작한대
		int ans = 0;
		int mid = len[N-1] / 2;
		
		while(true) {
			int cnt = 0;	
			for(int i = 0; i < N; i++) {
				cnt += (len[i] / mid);
			}
			
			if(cnt == M) {
				ans = Math.max(ans, mid);
			}
			mid = mid / 2;
			
			if(cnt > M) break;
		}
		
		System.out.println(ans);
	}

}
