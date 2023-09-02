package algo0614;

import java.io.*;
import java.util.StringTokenizer;

public class boj16953 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//1. 10의 9승이면 뭐로 받아야할까
		
		//162라는 값에서 2로 나누다가 안나눠지는순간 (일의자리)1을 빼주고 다시 2로 나누다가 n값되면 끝
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		long midValue = M;
		int odd = 0, cnt = 1;
		while(true) {
			if(midValue < N) { //탈출조건이 이게 맞나
				System.out.println(-1);
				return;
			}
			if(midValue == N) {
				System.out.println(cnt);
				return;
			}

			if(midValue % 2 == 0) {
				midValue = midValue / 2;
			}
			else {
				if(midValue % 10 == 1) {
					midValue = midValue / 10;
				}
				else {
					System.out.println(-1);
					return;
				}
			}
			cnt++;
		}
	}

}
