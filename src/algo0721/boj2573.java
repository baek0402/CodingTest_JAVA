package algo0721;

import java.io.*;
import java.util.*;

public class boj2573 {

	static int n, m;
	static int[][] mat; //ó�� ����
	static int[][] height; //���� ����
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
		
		//���� Ǯ��
		//���� ��ġ�� ������ �������ִ� '0'�� ������ŭ ������Ѵ�
		//�׷��� �ؼ� ���������� 2���� �������ִ� ������ �ð��� ����ϸ�ȴ�.
		
		//for�� ���鼭 ó�� ������ �߰��ϱ�
		while(true) {
			//������ �ϳ��� ������ ���� ��쿣 0
			if(!check()) {
				year = 0;
				break;
			}
			
			//��� �κ�
			//melt();
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(mat[i][j] != 0 && !visited[i][j]) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			
			//������ 2�� �̻����� ������ ����� year(����)		
			/* ���⿡ ������ ������ cnt�� �и��� ���� ������ ���� ī��Ʈ�̱� ������ 
			 * ���� ���� for������ ���������� ���� �˻簡 ���� ���Ŀ� Ȯ���ؾ��ϱ� ���� */
			if(cnt >= 2) {
				break;
			}
			year++;

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					mat[i][j] = height[i][j]; //���� �ٲ� ���̷�..
					
					visited[i][j] = false;
					cnt = 0;
					//���⼭�� �湮�̳� cnt �ٽ� ����, ������̰� ���� reset �Ǿ����ϱ�
				}
			}

		}
		System.out.println(year);		
	}
	
	//check�� ������ ��ü�� 0�ΰ�쿡�� 0�� ����ؾ��ϱ� ������ (�����ڵ� ����)
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

			int zeroCnt = 0; //���� �ֺ��� ���� cnt	
			
			//���� ���� ���̸� ���� ���
			//1. ������ ��ġ�� 0�� ������� Ȯ���ϱ�
			for(int dir = 0; dir < 4; dir++) {
				int nx = now[0] + dx[dir];
				int ny = now[1] + dy[dir];
							
				if(nx < 0 || nx >= n || ny < 0 || ny >= m || mat[nx][ny] != 0) continue;
				if(mat[nx][ny] == 0) {
					zeroCnt++;
				}
			}
			//2. 0�� ������ŭ ���ֱ�
			if(mat[now[0]][now[1]] < zeroCnt) 
				height[now[0]][now[1]] = 0;
			else 
				height[now[0]][now[1]] = mat[now[0]][now[1]] - zeroCnt;			
			
			//�˻��� ���� ��ġ(bfs)
			for(int dir = 0; dir < 4; dir++) {
				int nx = now[0] + dx[dir];
				int ny = now[1] + dy[dir];
							
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if(mat[nx][ny] == 0 || visited[nx][ny]) continue;
				//mat�� 0�̰�(��), �̹� �湮�� ������ continue....
				
				que.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
		//1�⿡ ���� �ϳ��� ��ƾ�� ��������

	}
}
