package algo0706;

import java.util.*;
import java.io.*;

public class pro_폰켓몬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public int solution(int[] nums) {
	        Map<Integer, Integer> m = new HashMap<>();
	        //1. 고를 수 있는 최대 수 nums.length의 절반
	        //2. 그 중 겹치지 않는 선에서 최대
	        for(int i = 0; i < nums.length; i++) {
	            m.put(nums[i], m.getOrDefault(m, 0) + 1);
	        }
	    
	        int answer = 0;
	        if(m.size() > nums.length / 2) //각기 다른 종류가 어차피 고를 수 있는 최대 경우의 수보다 크면, 그냥 최대 뽑을 수 있는 N/2가 정답이 됨
	            answer = nums.length / 2;
	        else
	            answer = m.size();
	        
	        return answer;
	    }
	}
}
