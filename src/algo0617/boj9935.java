package algo0617;

import java.util.*;
import java.io.*;

public class boj9935 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char str[] = br.readLine().toCharArray();
		char bomb[] = br.readLine().toCharArray(); // ���߹��ڿ�
		
		/* str���� pop�ϸ鼭 bomb�� �񱳸� �Ѵ�.
		 * 4
		 * 
		 * 
		 */
		int cnt = 0;
		Stack<Character> stack = new Stack<>();
		for(int i=0; i < str.length; i++) {
			stack.push(str[i]);
		}
		
		// 4�϶� �ٷ� �������� 4�̰ų� C�̰ų�..
//		while(true) {
//			if(stack.pop() == bomb[]) { 
//				
//			}
//			
//		}
		
		
	}
}
