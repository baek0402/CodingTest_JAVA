
import java.util.*;
import java.io.*;

public class boj1213 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String[] str = br.readLine().split(""); //AABB를 하나씩자르기
		char[] str = br.readLine().toCharArray(); 
		
		int[] alpha = new int[26]; // 26으로 해줘도 돼
		
		//1. 알파벳별 개수를 세어준다 -'A'
		int idx = 0;
		for(int i = 0; i < str.length; i++) {
			idx = str[i] - 'A';
			alpha[idx]++;
		}
		/*
		for(int i = 0; i < alpha.length; i++) {
			System.out.println(alpha[i]);
		}*/
		
		//2. odd >= 2 탈출조건 + mid값 저장
		//알파벳이 홀수개인게 2개 이상이면 조건 성립 불가
		int odd = 0;
		int mid = 0;
		for(int i = 0; i < alpha.length; i++) {			
			if(alpha[i] % 2 != 0) {
				odd++;
				mid = i;
			}
			if(odd >= 2) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
		}
		//System.out.println((char)(mid + 'A'));
		
		StringBuilder sb = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		//3. 절반만 출력해주기 총 길이가 4면 2만..
		//A:2, B:2, C:2면 가각 한번씩만 ABC하고,,
		for(int i = 0; i < alpha.length; i++) {
			for(int j = 0; j < alpha[i] / 2; j++) {
				char index = (char)('A' + i);
				sb.append(index);
			}
		}
		ans.append(sb);
		
		//4. 중앙값 붙이고 
		if(odd == 1) ans.append((char)(mid + 'A'));
		
		//5. 나머지는 reverse로 붙여주기
		sb.reverse();
		ans.append(sb);
		
		System.out.println(ans.toString());
	}
}
