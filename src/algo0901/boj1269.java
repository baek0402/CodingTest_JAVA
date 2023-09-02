package algo0901;

import java.util.*;
import java.io.*;

public class boj1269 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<Integer> s1 = new HashSet<>();
		Set<Integer> s2 = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			s1.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			s2.add(Integer.parseInt(st.nextToken()));
		}

		//A-B {1, 2, 4} - {2, 3, 4, 5, 6}
		int cnt = 0;
		int ans = 0;
		for(int num : s2) {
			if(s1.contains(num))
				cnt++; //겹치는 개수만큼 s1의 전체개수에서 빼는..
		}
		ans = s1.size() - cnt;
		
		cnt = 0;
		//B-A {2, 3, 4, 5, 6} - {1, 2, 4}
		for(int num : s1) {
			if(s2.contains(num))
				cnt++;
		}
		ans += s2.size() - cnt;
		
		System.out.println(ans);
	}

}
