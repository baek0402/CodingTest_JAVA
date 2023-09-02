package algo0624;

import java.util.*;
import java.io.*;

public class prog_stock {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] prices = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}
		
		Queue<Position> q = new ArrayDeque<>();
		int[] answer = new int[prices.length];
		        
		for(int i = 0; i < prices.length; i++) {
			q.offer(new Position(prices[i], i));
			//큐에 하나씩 인덱스(순서)와 함께 넣는다              
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			Position p = q.poll(); //
		    int cnt = 1;
			//System.out.println(p.idx + " " + p.price);
			
			for(int i = p.idx + 1; i < prices.length; i++) {
				if(p.idx == prices.length-1) {
					answer[p.idx] = 0;
					break;
				}
				
				if(p.price > prices[i]) {
					System.out.println(p.price + " ~~ " + cnt);
					
					//가격 떨어진 시점
		            answer[p.idx] = cnt;
		            cnt = 1;
		            break;
		            
		        }
		        else {
		        	//가격 떨어지지 않은 횟수 cnt
		            cnt++;
		        }		        
		    }
			answer[p.idx] = cnt;
			
		}
		for(int i = 0; i < prices.length; i++) {
			System.out.println(answer[i]);
		}
	}
}

class Position {
	int price;
	int idx;
	
	public Position(int price, int idx) {
		this.price = price;
		this.idx = idx;
	}
}
