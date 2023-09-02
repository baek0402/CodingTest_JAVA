
import java.util.*;
import java.io.*;

public class boj1213 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String[] str = br.readLine().split(""); //AABB�� �ϳ����ڸ���
		char[] str = br.readLine().toCharArray(); 
		
		int[] alpha = new int[26]; // 26���� ���൵ ��
		
		//1. ���ĺ��� ������ �����ش� -'A'
		int idx = 0;
		for(int i = 0; i < str.length; i++) {
			idx = str[i] - 'A';
			alpha[idx]++;
		}
		/*
		for(int i = 0; i < alpha.length; i++) {
			System.out.println(alpha[i]);
		}*/
		
		//2. odd >= 2 Ż������ + mid�� ����
		//���ĺ��� Ȧ�����ΰ� 2�� �̻��̸� ���� ���� �Ұ�
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
		//3. ���ݸ� ������ֱ� �� ���̰� 4�� 2��..
		//A:2, B:2, C:2�� ���� �ѹ����� ABC�ϰ�,,
		for(int i = 0; i < alpha.length; i++) {
			for(int j = 0; j < alpha[i] / 2; j++) {
				char index = (char)('A' + i);
				sb.append(index);
			}
		}
		ans.append(sb);
		
		//4. �߾Ӱ� ���̰� 
		if(odd == 1) ans.append((char)(mid + 'A'));
		
		//5. �������� reverse�� �ٿ��ֱ�
		sb.reverse();
		ans.append(sb);
		
		System.out.println(ans.toString());
	}
}
