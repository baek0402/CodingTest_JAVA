package algo0925;

import java.util.*;

public class prog_모의고사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public int[] solution(int[] answers) {
	        int[] a = {1, 2, 3, 4, 5};
	        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
	        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	        
	        int[] answer = new int[3];
	        for(int i = 0, j = 0; i < answers.length; i++, j++) {            
	            if(a[j % a.length] == answers[i]) {
	                answer[0]++;
	            }
	            if(b[j % b.length] == answers[i]) {
	                answer[1]++;
	            }
	            if(c[j % c.length] == answers[i]) {
	                answer[2]++;
	            }
	        }
	        int maxVale = Math.max(answer[0], answer[1]);
	        maxVale = Math.max(answer[2], maxVale);
	        
	        List<Integer> list = new ArrayList<>();
	        for(int i = 0; i < 3; i++) {
	            if(maxVale == answer[i]) {
	                 list.add(i); //5, 0, 0
	            }
	        }
	        System.out.println(answer[1]);
	        
	        int[] arr = new int[list.size()];
	        int i = 0;
	        for(int num : list) {
	            arr[i] = num+1;
	            i++;
	        }
	        
	        return arr;
	    }
	}
}
