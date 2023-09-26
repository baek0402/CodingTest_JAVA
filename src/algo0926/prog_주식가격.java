package algo0926;
import java.util.*;
import java.io.*;

public class prog_주식가격 {
	class Solution {
	    public int[] solution(int[] prices) {
	        //'떨어지지않은기간'
	        //3, 2, 4, 1, 1
	        //즉 떨어지기 전까지 계산하기!
	        int[] answer = new int[prices.length];
	        Queue<Integer> que = new ArrayDeque<>();
	        for(int i = 0; i < prices.length; i++) {
	            que.offer(prices[i]);
	        }
	        
	        int num = que.poll(); //1
	        int idx = 0;
	        while(!que.isEmpty()) {
	            for(int i = idx; i < prices.length-1; i++) {
	                if(num <= prices[i]) 
	                    answer[idx]++;
	                else
	                    break;
	            }
	            num = que.poll();
	            idx++;
	        }
	        
	        return answer;
	    }
	}
}
