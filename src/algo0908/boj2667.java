package algo0908;

import java.util.*;
import java.io.*;

public class boj2667 {
	//�������� �����ϴ°� ��������
	//static String[] str;
	static char[][] board;
	static int[] count;
	static int cnt = 0;
	static int N;
	static boolean[][] visited;
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new char[N][N];
		visited = new boolean[N][N];
		count = new int[N*N];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			//String str = br.readLine();
			for(int j = 0; j < N; j++) {
				board[i][j] = str[j].charAt(0);
				//str[j]��° �迭�� j�ε��� ��ġ�� �ִ� ���ڼ���
				//�� �״ϱ� �̰Ŵ� �� str.charAt(j) �̷�����
				
				//board[i][j] = str.charAt(j);
			}
		}
		Stack<int[]> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				if(board[i][j] == '1' && !visited[i][j]) {
					cnt++; //���ο� ���� �߰�
					count[cnt]=1;
					stack.push(new int[] {i, j});
					visited[i][j] = true;
					
					while(!stack.isEmpty()) {
						int[] now = stack.pop();
						
						for(int dir=0; dir<4; dir++) {
							int nx = now[0] + dx[dir];
							int ny = now[1] + dy[dir];
								
							if(nx >= N || nx < 0 || ny >= N || ny < 0) 
								continue;
							if(visited[nx][ny] || board[nx][ny] == '0') 
								continue;
							
							//System.out.println("�������" + i + "," + j+ ":" + nx + "," + ny);
							stack.push(new int[] {nx, ny});
							visited[nx][ny] = true;
							count[cnt]++;
						}
					}
				}
			}
		}

		Arrays.sort(count);
		StringBuilder sb = new StringBuilder();
		sb.append(cnt + "\n");
		for(int z = 0; z < count.length; z++) {
			//���⼭ 0�ΰ� ���߰���?
			if(count[z] > 0) {
				sb.append(count[z] + "\n");
			}
		}
		System.out.println(sb);	
	}
	
	/*public static void bfs(int x, int y, int cnt) {
		//Stack<int[]> stack = new Stack<>();
		//stack.push(new int[] {x, y});
		//��ģ stack�� ���°� �ƴϷ�..
		count[cnt]++; //����� �ؾ� +1������
		visited[x][y] = true;
		for(int dir=0; dir<4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
				
			if(nx >= N || nx < 0 || ny >= N || ny < 0) 
				continue;
			if(visited[nx][ny] || board[nx][ny] == '0') 
				continue;

			bfs(nx, ny, cnt);
		}
	}*/
}
