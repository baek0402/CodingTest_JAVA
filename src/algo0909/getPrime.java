package algo0909;

import java.util.Scanner;

public class getPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		//�Ҽ��� �ᱹ 1�̶� �ڱ��ڽŸ� ���ƾ��� �׷��� 
		if(N == 0 || N == 1) System.out.println(-1);
		for(int i = 2; i <= 7; i++) {
			if(N % i == 0)
				System.out.println(N);			
		}
	}

}
