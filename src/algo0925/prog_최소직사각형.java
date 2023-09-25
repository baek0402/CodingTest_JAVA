package algo0925;
import java.util.*;
import java.io.*;


public class prog_최소직사각형 {
	class Solution {
	    public int solution(int[][] sizes) {
	        /*
	        60 50
	        30 70
	        60 30
	        80 40
	        
	        10 7
	        12 3
	        8  15
	        14 7
	        5  15
	        
	        한쪽으로 몰아버려
	        */
	        int x = 0;
	        int y = 0;
	        for(int i = 0; i < sizes.length; i++) {
	            if(sizes[i][0] < sizes[i][1]) {
	                int temp = sizes[i][0];
	                sizes[i][0] = sizes[i][1];
	                sizes[i][1] = temp;
	            }
	            x = Math.max(sizes[i][0], x);
	            y = Math.max(sizes[i][1], y);
	        }
	        return x * y;
	    }
	}
}
