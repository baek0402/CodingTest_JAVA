package algo0614;

import java.io.*;
import java.util.StringTokenizer;

public class boj16953 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//1. 10�� 9���̸� ���� �޾ƾ��ұ�
		
		//162��� ������ 2�� �����ٰ� �ȳ������¼��� (�����ڸ�)1�� ���ְ� �ٽ� 2�� �����ٰ� n���Ǹ� ��
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		long midValue = M;
		int odd = 0, cnt = 1;
		while(true) {
			if(midValue < N) { //Ż�������� �̰� �³�
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
