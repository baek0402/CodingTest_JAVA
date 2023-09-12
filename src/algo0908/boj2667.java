package algo0908;

import java.util.*;
import java.io.*;

public class boj2667 {
	//전역변수 선언하는거 잊지말기
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
				//str[j]번째 배열의 j인덱스 위치에 있는 문자선택
				//아 그니까 이거는 걍 str.charAt(j) 이런경우넹
				
				//board[i][j] = str.charAt(j);
			}
		}
		Stack<int[]> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				if(board[i][j] == '1' && !visited[i][j]) {
					cnt++; //새로운 구역 발견
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
							
							//System.out.println("여기오냐" + i + "," + j+ ":" + nx + "," + ny);
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
			//여기서 0인건 빼야겠지?
			if(count[z] > 0) {
				sb.append(count[z] + "\n");
			}
		}
		System.out.println(sb);	
	}
	
	/*public static void bfs(int x, int y, int cnt) {
		//Stack<int[]> stack = new Stack<>();
		//stack.push(new int[] {x, y});
		//미친 stack을 쓰는게 아니래..
		count[cnt]++; //여기다 해야 +1해진댕
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
