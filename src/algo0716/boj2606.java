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
		
		/* 접근방법
		 * (1,2)가 연결되어 있으면 (2,1)도 연결이 되어있음
		 * 그래서 7*7로 접근을 했을 때, 해당하는 위치는 1로 해주고
		 * 이런식으로 연결되어있는 칸을 1로 채워주기..
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
		
		for(int i = 1; i <= cmp; i++) { //노드의 개수 (7)
			if(!visited[i] && arr[now][i] == 1) {
				dfs(i);
				cnt++;
			}
		}
	}

}
