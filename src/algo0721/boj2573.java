package algo0721;

import java.io.*;
import java.util.*;

public class boj2573 {

	static int n, m;
	static int[][] mat; //처음 상태
	static int[][] height; //빙산 높이
	static boolean[][] visited;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	static int cnt = 0;
	static int year = 0;
	
	static Queue<int[]> que;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		mat = new int[n][m];
		height = new int[n][m];
		visited = new boolean[n][m];
		que = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				height[i][j] = mat[i][j];
			}
		}
		
		//문제 풀이
		//내가 위치한 지점에 인접해있는 '0'의 개수만큼 빼줘야한다
		//그렇게 해서 최종적으로 2개가 떨어져있는 시점의 시간을 출력하면된다.
		
		//for문 돌면서 처음 시작점 발견하기
		while(true) {
			//빙산이 하나도 나뉘지 않은 경우엔 0
			if(!check()) {
				year = 0;
				break;
			}
			
			//녹는 부분
			//melt();
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(mat[i][j] != 0 && !visited[i][j]) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			
			//빙산이 2개 이상으로 나뉘는 경우의 year(정답)		
			/* 여기에 선언한 이유는 cnt가 분리된 빙산 영역에 대한 카운트이기 때문에 
			 * 위의 이중 for문에서 영역개수에 대한 검사가 끝난 직후에 확인해야하기 때문 */
			if(cnt >= 2) {
				break;
			}
			year++;

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					mat[i][j] = height[i][j]; //새로 바뀐 높이로..
					
					visited[i][j] = false;
					cnt = 0;
					//여기서는 방문이나 cnt 다시 리셋, 빙산높이가 새로 reset 되었으니까
				}
			}

		}
		System.out.println(year);		
	}
	
	//check은 빙산이 전체가 0인경우에는 0을 출력해야하기 때문에 (재헌코드 참고)
	static boolean check() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(mat[i][j] > 0)
					return true;
			}
		}
		return false;
	}
	
	static void bfs(int x, int y) {
		que.offer(new int[] {x, y});		
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int now[] = que.poll();

			int zeroCnt = 0; //빙산 주변에 대한 cnt	
			
			//다음 빙산 높이를 위한 계산
			//1. 지점한 위치에 0이 몇개인지를 확인하기
			for(int dir = 0; dir < 4; dir++) {
				int nx = now[0] + dx[dir];
				int ny = now[1] + dy[dir];
							
				if(nx < 0 || nx >= n || ny < 0 || ny >= m || mat[nx][ny] != 0) continue;
				if(mat[nx][ny] == 0) {
					zeroCnt++;
				}
			}
			//2. 0의 개수만큼 빼주기
			if(mat[now[0]][now[1]] < zeroCnt) 
				height[now[0]][now[1]] = 0;
			else 
				height[now[0]][now[1]] = mat[now[0]][now[1]] - zeroCnt;			
			
			//검사할 다음 위치(bfs)
			for(int dir = 0; dir < 4; dir++) {
				int nx = now[0] + dx[dir];
				int ny = now[1] + dy[dir];
							
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if(mat[nx][ny] == 0 || visited[nx][ny]) continue;
				//mat이 0이고(물), 이미 방문을 했으면 continue....
				
				que.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
		//1년에 대한 하나의 루틴이 마무리됨

	}
}
