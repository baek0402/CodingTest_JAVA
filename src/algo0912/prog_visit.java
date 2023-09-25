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
	                //�̹� �湮�� ��θ� �׳� �� �̵��� ���ְ� count�� ������ �ʴ´�
	                que.poll();
	                que.offer(new int[] {nx, ny});
	                continue;
	            }
	            
	            System.out.println(nx + "," + ny);
	            
	            //���ι湮�ϴ°�ζ�� �ش���true�ϰ�
	            visited[now[0]][now[1]][nx][ny] = true;
	            visited[nx][ny][now[0]][now[1]]=true;
	            
	            cnt++;
	            que.poll(); 
	            //���⼭ poll�� �ϴ� ������ ���� �ڵ带 �ʹ� �������� ¥��..
	            //���࿡ ���� ��ġ�� ù��° if������ �ɷ�����, ���� dir�� ��ġ�� ���� �ڵ忡�� ����Ǿ���ϴµ�,
	            //�� �տ��� poll�ع�����.. �� null ������ �߻��մϴ�.. ��
	            que.offer(new int[] {nx, ny});
	        }
	    
	        return cnt;
	    }
	}
}
