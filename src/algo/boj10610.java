package algo;

import java.util.*;
import java.io.*;

//boj10610 : 30
public class boj10610 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String[] arr = br.readLine().split("");
				
		//1. ���ڿ��� �ް�
		Arrays.sort(arr);

		StringBuilder bs = new StringBuilder();
		for(int i=0; i < arr.length; i++) {
			bs.append(arr[i]);
		}
		bs.reverse(); //�ٽ� �������� ���� �� (???)
		
		int sum = 0;
		
		StringBuilder answer = new StringBuilder();
		//2. 10���� �������°�?
		//reverse���� �׳� for���� �Ųٷ� ���� �ð� ����!
		for(int i=0; i < arr.length; i++) {
			int num = bs.charAt(i) - '0';
			sum += num;
			answer.append(num);
		}	
		//3. ���ڸ����� ���� 3�� ����̸�

		if(!arr[0].equals("0") || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer.toString());
	}
}
