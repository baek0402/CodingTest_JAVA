package algo0706;

import java.util.*;
import java.io.*;

public class pro_���ϸ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public int solution(int[] nums) {
	        Map<Integer, Integer> m = new HashMap<>();
	        //1. �� �� �ִ� �ִ� �� nums.length�� ����
	        //2. �� �� ��ġ�� �ʴ� ������ �ִ�
	        for(int i = 0; i < nums.length; i++) {
	            m.put(nums[i], m.getOrDefault(m, 0) + 1);
	        }
	    
	        int answer = 0;
	        if(m.size() > nums.length / 2) //���� �ٸ� ������ ������ �� �� �ִ� �ִ� ����� ������ ũ��, �׳� �ִ� ���� �� �ִ� N/2�� ������ ��
	            answer = nums.length / 2;
	        else
	            answer = m.size();
	        
	        return answer;
	    }
	}
}
