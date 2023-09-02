package algo0616_stack;

import java.io.*;
import java.util.*;

public class boj1874 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*
		 * 8 ( 1 2 3 4 5 6 7 8)
		 * 4 3 6 8 7 5 2 1 수열을 만들어야하니
		4가 나오려면 1 2 3 4 넣고 4를 빼고 3 나와야하니까 또 빼주고
		6나오려면 1234 에서 5,6 넣어야하니까 + + 하고 - 해주고 8 하려면
		또 거기서..
		
		1. 최초 입력값까지 push 와 pop 하고 (마지막 push위치 기억하기)
		2. 다음값이 방금 뺀 값보다 작으면 pop하고 /
		3. 아니면 2번 입력값까지 push + pop (마지막 push위치 기억)
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 8

		Stack<Integer> stack = new Stack<>(); //N만큼 넣기
		
		int cnt = 1;
		int lastPushValue = 1;
		int idx = 1;
		while(cnt <= N) {
			int M = Integer.parseInt(br.readLine());
			
			while(idx <= M) {
				sb.append("+\n");
				stack.push(idx);
				idx++; //5
			}
			
			//지금입력받은값이 되었을 때 pop해줘야지
			lastPushValue = stack.peek(); //4
			if(M != lastPushValue) {
				System.out.println("NO\n");
				return;
			}
			sb.append("-\n");
			stack.pop();
			
			cnt++;
		}
		System.out.println(sb.toString());
	}
}
