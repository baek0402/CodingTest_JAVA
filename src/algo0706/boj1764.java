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
		
		/* 1. ���ڿ��� �޴´�
		 * 2. ���ڿ� ��ü�� �˾Ƽ� �����ֳ�?
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
				ans.put(s2, cnt); //�����ؼ� ����ϱ� ���� TreeMap�� �� �־��ֱ�
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
