package algo0706;

import java.util.*;
import java.io.*;

public class boj1764 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> m = new HashMap<>();
		Map<String, Integer> ans = new TreeMap<>();
		
		/* 1. 문자열을 받는다
		 * 2. 문자열 전체를 알아서 비교해주낭?
		 */
		
		StringBuilder sb = new StringBuilder();
		String s1 = "";
		String s2 = "";
		for(int i = 0; i < N; i++) {
			s1 = br.readLine();
			m.put(s1, i);
		}
		
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			s2 = br.readLine();
			
			if(m.containsKey(s2)) {				
				ans.put(s2, cnt); //정렬해서 출력하기 위해 TreeMap에 답 넣어주기
				cnt++;
			}
		}
		
		System.out.println(cnt);
		for(String s : ans.keySet()) {
			sb.append(s + "\n");
		}
		System.out.println(sb.toString());
	}

}
