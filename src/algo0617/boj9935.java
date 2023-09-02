package algo0617;

import java.util.*;
import java.io.*;

public class boj9935 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char str[] = br.readLine().toCharArray();
		char bomb[] = br.readLine().toCharArray(); // 폭발문자열
		
		/* str값을 pop하면서 bomb와 비교를 한다.
		 * 4
		 * 
		 * 
		 */
		int cnt = 0;
		Stack<Character> stack = new Stack<>();
		for(int i=0; i < str.length; i++) {
			stack.push(str[i]);
		}
		
		// 4일때 바로 다음값도 4이거나 C이거나..
//		while(true) {
//			if(stack.pop() == bomb[]) { 
//				
//			}
//			
//		}
		
		
	}
}
