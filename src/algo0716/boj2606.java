package algo0716;

import java.util.*;
import java.io.*;

public class boj2606 {

	static int[][] arr;
	static boolean visited[];
	static int cnt = 0;
	static int cmp;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		cmp = Integer.parseInt(br.readLine()); // 7
		int num = Integer.parseInt(br.readLine());
		
		arr = new int[cmp +1][cmp+1];
		visited = new boolean[cmp+1];
		
		/* ���ٹ��
		 * (1,2)�� ����Ǿ� ������ (2,1)�� ������ �Ǿ�����
		 * �׷��� 7*7�� ������ ���� ��, �ش��ϴ� ��ġ�� 1�� ���ְ�
		 * �̷������� ����Ǿ��ִ� ĭ�� 1�� ä���ֱ�..
		 */
		
		for(int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			arr[f][s] = 1;
			arr[s][f] = 1;
		}
		dfs(1);
		System.out.println(cnt);
	}
	
	static void dfs(int now) {
		visited[now] = true;
		//cnt++;
		
		for(int i = 1; i <= cmp; i++) { //����� ���� (7)
			if(!visited[i] && arr[now][i] == 1) {
				dfs(i);
				cnt++;
			}
		}
	}

}
