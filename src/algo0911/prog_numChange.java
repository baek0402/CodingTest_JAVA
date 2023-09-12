package algo0911;
import java.util.*;
import java.io.*;

public class prog_numChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        // x * n, x * 2, x * 3
			int x = 2;
			int y = 5;
			int n = 4;
	        
	        int[] dist = new int[1000001]; //ø÷ 2000000¿Ã¡ˆ?
	        
	        Queue<Integer> que = new ArrayDeque<>();
	        que.offer(x);
	        
	        int answer = 0;
	        while(!que.isEmpty()) {
	            int num = que.poll(); // 10

	            if(num == y) {
	                System.out.println(y);
	                //System.out.println(dist[y]);
	            }
	            
	            if(num+n <= 1000000 && dist[num+n]==0) {
	                que.offer(num+n);
	                dist[num+n] = dist[num] + 1;
	            }
	            if(num*2 <= 1000000 && dist[num*2] == 0) {
	                que.offer(num*2);
	                dist[num*2] = dist[num] + 1;
	            }
	            if(num*3 <= 1000000 && dist[num*3] == 0) {
	                que.offer(num*3);
	                dist[num*3] = dist[num]+1;
	            }
	        }
	        
	        System.out.println(-1);
	    }
}
