package algo0912;

import java.util.*;
import java.io.*;


public class prog_visit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public int solution(String dirs) {
	        //U L R D
	        int cnt = 0;
	        boolean[][][][] visited = new boolean[11][11][11][11];
	        Queue<Character> dir = new ArrayDeque<>();
	        Queue<int[]> que = new ArrayDeque<>();
	        for(int i = 0; i < dirs.length(); i++) {
	            dir.offer(dirs.charAt(i));
	        }
	        que.offer(new int[] {5, 5});
	        
	        while(!dir.isEmpty()) {
	            char c = dir.poll(); //U
	            int[] now = que.peek(); //5, 5
	            int nx = now[0];
	            int ny = now[1];
	                        
	            if(c == 'U')
	                nx = now[0] - 1;
	            else if(c == 'L')
	                ny = now[1] - 1;
	            else if(c == 'R')
	                ny = now[1] + 1;
	            else if(c == 'D')
	                nx = now[0] + 1;
	            
	            if(nx > 10 || nx < 0 || ny > 10 || ny < 0) continue;
	            if(visited[now[0]][now[1]][nx][ny] || visited[nx][ny][now[0]][now[1]]) {
	                //이미 방문한 경로면 그냥 점 이동만 해주고 count는 해주지 않는다
	                que.poll();
	                que.offer(new int[] {nx, ny});
	                continue;
	            }
	            
	            System.out.println(nx + "," + ny);
	            
	            //새로방문하는경로라면 해당경로true하고
	            visited[now[0]][now[1]][nx][ny] = true;
	            visited[nx][ny][now[0]][now[1]]=true;
	            
	            cnt++;
	            que.poll(); 
	            //여기서 poll을 하는 이유는 내가 코드를 너무 그지같이 짜서..
	            //만약에 점의 위치가 첫번째 if문에서 걸러지면, 다음 dir의 위치가 현재 코드에서 진행되어야하는데,
	            //이 앞에서 poll해버리면.. 그 null 오류가 발생합니다.. ㅠ
	            que.offer(new int[] {nx, ny});
	        }
	    
	        return cnt;
	    }
	}
}
