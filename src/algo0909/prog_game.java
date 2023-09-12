package algo0909;
import java.util.*;
import java.io.*;

public class prog_game {
	static boolean[][] visited;
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] dist;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
	        
	        n = maps.length;
	        m = maps[0].length; //n * m
	        dist = new int[n][m];
	        visited = new boolean[n][m];
	        
	        Queue<int[]> que = new ArrayDeque<>();
	        que.offer(new int[] {0, 0}); //시작점
	        visited[0][0] = true;
	        
	        while(!que.isEmpty()) {
	            int[] now = que.poll();
	            
	            for(int dir = 0; dir < 4; dir++) {
	                int nx = now[0] + dx[dir];
	                int ny = now[1] + dy[dir];
	                
	                if(nx >= n || nx > 0 || ny >= m || ny > 0) {
	                    //탈출 조건
	                    if(nx == n && ny == m)
	                        break;
	                    continue;
	                }
	                if(visited[nx][ny] || maps[nx][ny] != 1) continue;
	                
	                visited[nx][ny] = true; //방문 처리
	                dist[nx][ny] = dist[now[0]][now[1]] + 1;
	                que.offer(new int[] {nx, ny});
	            }
	        }
	        
	        if(dist[n-1][m-1] == 0) System.out.println(-1);
	        else System.out.println(dist[n-1][m-1]);
	}
}
