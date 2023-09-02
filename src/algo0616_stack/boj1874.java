package algo0616_stack;

import java.io.*;
import java.util.*;

public class boj1874 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*
		 * 8 ( 1 2 3 4 5 6 7 8)
		 * 4 3 6 8 7 5 2 1 ������ �������ϴ�
		4�� �������� 1 2 3 4 �ְ� 4�� ���� 3 ���;��ϴϱ� �� ���ְ�
		6�������� 1234 ���� 5,6 �־���ϴϱ� + + �ϰ� - ���ְ� 8 �Ϸ���
		�� �ű⼭..
		
		1. ���� �Է°����� push �� pop �ϰ� (������ push��ġ ����ϱ�)
		2. �������� ��� �� ������ ������ pop�ϰ� /
		3. �ƴϸ� 2�� �Է°����� push + pop (������ push��ġ ���)
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 8

		Stack<Integer> stack = new Stack<>(); //N��ŭ �ֱ�
		
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
			
			//�����Է¹������� �Ǿ��� �� pop�������
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
