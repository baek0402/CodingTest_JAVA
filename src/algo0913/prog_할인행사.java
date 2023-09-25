package algo0913;

import java.util.*;
import java.io.*;


public class prog_할인행사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public int solution(String[] want, int[] number, String[] discount) {
	        //discount의 i=0부터 10까지 hash로 각 제품별 개수를 세어
	        //그때 want의 hash에 없는게있다면 i++해서 다음으로..
	        //그렇게해서 다 수량이 맞으면 cnt++해주긔 i=n ~ i=10+n 해서 이게 10보다 작아지면 끗

	        Map<String, Integer> wantMap = new HashMap<>();
	        for(int i = 0; i < want.length; i++) {
	            wantMap.put(want[i], number[i]);
	        }
	        
	        int answer = 0;
	        int cnt = 0;
	        while(10+cnt <= discount.length) {
	            boolean same = true;
	            Map<String, Integer> discountMap = new HashMap<>();
	            for(int i = cnt; i < 10+cnt; i++) { // 0~10 까지의
	                discountMap.put(discount[i], discountMap.getOrDefault(discount[i],0)+1);
	            }
	            for(String product : discountMap.keySet()) {
	                if(wantMap.containsKey(product)) {
	                    if(wantMap.get(product) != discountMap.get(product)) {
	                        same = false;
	                        break; //while문으로가는건가?
	                    }
	                }
	                else {
	                    same = false;
	                    break;
	                }
	            }
	            if(same) answer++;
	            cnt++;
	        }

	        return answer;
	    }
	}
}
