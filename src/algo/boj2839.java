package algo;
import java.util.*;

public class boj2839 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int n;
		n = sc.nextInt();
		
		while(n >= 0) {
			if(n % 5 == 0) {
				sum += n / 5;
				n %= 5;
				
				if(n == 0) {
					System.out.println(sum);
					return;
				}
			}
			n -= 3;
			sum++;
		}
		System.out.println(-1);
	}

}
