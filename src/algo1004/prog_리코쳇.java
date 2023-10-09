package algo1004;
import java.util.*;
import java.io.*;

public class prog_리코쳇 {
	class Solution {
	    int[] dx = {-1, 0, 1, 0};
	    int[] dy = {0, 1, 0, -1};
	    boolean[][] visited;
	    char[][] bd;
	    int[][] dist;
	    public int solution(String[] board) {
	        int N = board.length;
	        int M = board[0].length();
	        Queue<int[]> que = new ArrayDeque<>();
	        visited = new boolean[N][M];
	        bd = new char[N][M];
	        dist = new int[N][M];
	        for(int i = 0; i < N; i++) {
	            for(int j = 0; j < M; j++) {
	                bd[i][j] = board[i].charAt(j);
	                if(bd[i][j] == 'R') {
	                    que.offer(new int[] {i, j});
	                    visited[i][j] = true;
	                }
	                if(bd[i][j] == 'G') {
	                    
	                }
	            }
	        }
	        int cnt = 0;
	        while(!que.isEmpty()) {
	            int[] now = que.poll();
	            
	            for(int dir = 0; dir < 4; dir++) {
	                int nx = now[0] + dx[dir]; // 0, 6
	                int ny = now[1] + dy[dir];

	                
	                //1. 먼저 미끄러지는 위치 지정하기
	                while(true) {
	                    //보드를 벗어나거나
	                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
	                    
	                    //D와 부딪히는 경우
	                    if(bd[nx][ny] == 'D') break;
	                    
	                    //가 아니면 계속 전진
	                    nx += dx[dir];
	                    ny += dy[dir];
	                }
	                
	                int x = nx - dx[dir];
	                int y = ny - dy[dir];
	                if(visited[x][y]) continue;
	                
	                System.out.println(x + "," + y);
	                if(bd[x][y] == 'G') {
	                    System.out.println(dist[now[0]][now[1]]+1);
	                    return dist[now[0]][now[1]] + 1;
	                }
	                que.offer(new int[] {x, y});
	                visited[x][y] = true;
	                dist[x][y] = dist[now[0]][now[1]] + 1;
	            }
	        }
	        
	        return -1;
	    }
	}
}
