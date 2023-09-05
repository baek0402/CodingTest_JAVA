package algo0905;

import java.util.*;
import java.io.*;

public class prog_stack2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] solution(int[] progresses, int[] speeds) {
		//100-���� �ؼ� speed * n�� > 100
	        
	    //1. 7, 70, 45 ���� 100�� �Ѵ� ������ ������ �Ź� ����
	    int cnt = -1; int value = 0;
	    int maxValue = 0;
	    List<Integer> list = new ArrayList<>();
	    for(int i = 0; i < progresses.length; i++) {
	    	int rest = 100-progresses[i];
	        int num = rest / speeds[i]; //7, 2, 1
	        if(num * speeds[i] + progresses[i] < 100) num += 1;
	            
	        value++;
	        if(maxValue < num) {
	        	cnt++;
	        	value = 1;
	            maxValue = Math.max(maxValue, num);
	                
	            list.add(cnt, value);
	        }
	        //arr[cnt]++;
	        list.set(cnt, value);
	        System.out.println(cnt + "," + value);
	            
	    }

	    int[] answer = new int[list.size()];
	    int idx = 0;
	    for(int i = 0; i < list.size(); i++) {
	    	answer[i] = list.get(i);
	    }
	        
	    return answer;
	}
}
