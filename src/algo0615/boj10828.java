package algo0615;

import java.io.*;
import java.util.*;

public class boj10828 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken(); //push
			
			if(cmd.equals("push")) { // 1
				//push 3
				int num = Integer.parseInt(st.nextToken());//1
				stack.push(num);
			}
			else if(cmd.equals("pop")) {
				if(stack.isEmpty()) {
					sb.append(-1 + "\n");
					//continue;
				}
				else
					sb.append(stack.pop() + "\n");
			}
			else if(cmd.equals("size")) {
				sb.append(stack.size() + "\n");
			}
			else if(cmd.equals("empty")) {
				if(stack.isEmpty()) 
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
			}
			else if(cmd.equals("top")) {
				if(stack.isEmpty()) {
					sb.append(-1 + "\n");
				}
				else {
					sb.append(stack.peek() + "\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
