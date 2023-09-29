package algo0927;

import java.util.*;
import java.io.*;
public class prog_요격시스템 {

	class Solution {
		public int solution(int[][] targets) {
	        // 앞 내림, 뒤 오름 으로 하려했는데
	        // 그냥 뒤 내림차순으로해서 뒷 시간만 보면 된대
	        // 1,4
	        // 4,5
	        // 3,7
	        // 4,8
	        // 5,12
	        //11,13
	        //10,14
	        
	        Arrays.sort(targets,(o1,o2)-> {
	            return o1[1]-o2[1]; 
	        });
	        /*
	        Arrays.sort(targets, (o1, o2) -> {
	            if(o1[0] > o2[0]) return 1; //오름차순
	            else if(o1[0] < o2[0]) return -1;
	            else {
	                if(o1[1] > o2[1]) return -1;
	                else if(o1[1] < o2[1]) return 1;
	                else return 0;
	            }
	        });*/
	        
	        
	        int cnt = 1;
	        int lastTime = targets[0][1];
	        
	        for(int i = 1; i < targets.length; i++) {
	            if(lastTime <= targets[i][0]) { //끝난시간이랑 다음거 처음시간이 같거나 크면
	                lastTime = targets[i][1];
	                cnt++;
	            }
	        }
	        
	        return cnt;
	    }
}
}
