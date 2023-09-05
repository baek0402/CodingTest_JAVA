package algo;

import java.util.*;
import java.io.*;

//boj10610 : 30
public class boj10610 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String[] arr = br.readLine().split("");
				
		//1. 문자열로 받고
		Arrays.sort(arr);

		StringBuilder bs = new StringBuilder();
		for(int i=0; i < arr.length; i++) {
			bs.append(arr[i]);
		}
		bs.reverse(); //다시 내림차순 정렬 후 (???)
		
		int sum = 0;
		
		StringBuilder answer = new StringBuilder();
		//2. 10으로 나눠지는가?
		//reverse없이 그냥 for문을 거꾸로 돌면 시간 단축!
		for(int i=0; i < arr.length; i++) {
			int num = bs.charAt(i) - '0';
			sum += num;
			answer.append(num);
		}	
		//3. 각자릿수의 합이 3의 배수이면

		if(!arr[0].equals("0") || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer.toString());
	}
}
