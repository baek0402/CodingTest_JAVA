
import java.util.*;
import java.io.*;

public class pracitce {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String num = br.readLine();
		char[] arr = new char[num.length()];
		
		//1. 문자열로 받고
		for(int i=0; i < num.length(); i++) {
			arr[i] = num.charAt(i);
		}
		Arrays.sort(arr);
		
		int idx = 1;
		int sum = 0;
		Boolean poss = false;
		
		//2. 첫번째 자릿수가 0으로 끝나고
		if(arr[0] == '0') {
			while(idx < num.length()) {
				sum += (arr[idx] - '0');
				
				idx++;
			}
			//3. 각자릿수의 합이 3의 배수이면
			if(sum % 3 == 0) {
				poss = true;
			}
		}
		else {
			System.out.println(-1);
			return;
		}
		
		idx=num.length()-1;
		//각각 char을 다시 string으로..?
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
