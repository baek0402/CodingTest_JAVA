
import java.util.*;
import java.io.*;

public class pracitce {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String num = br.readLine();
		char[] arr = new char[num.length()];
		
		//1. ���ڿ��� �ް�
		for(int i=0; i < num.length(); i++) {
			arr[i] = num.charAt(i);
		}
		Arrays.sort(arr);
		
		int idx = 1;
		int sum = 0;
		Boolean poss = false;
		
		//2. ù��° �ڸ����� 0���� ������
		if(arr[0] == '0') {
			while(idx < num.length()) {
				sum += (arr[idx] - '0');
				
				idx++;
			}
			//3. ���ڸ����� ���� 3�� ����̸�
			if(sum % 3 == 0) {
				poss = true;
			}
		}
		else {
			System.out.println(-1);
			return;
		}
		
		idx=num.length()-1;
		//���� char�� �ٽ� string����..?
		String rslt = "";
		if(poss) {
			while(idx >= 0) {
				rslt += arr[idx];
				idx--;
			}
			return;
 		}
		System.out.println(-1);
	}
}
