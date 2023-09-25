package algo0913;

import java.util.*;
import java.io.*;


public class prog_������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public int solution(String[] want, int[] number, String[] discount) {
	        //discount�� i=0���� 10���� hash�� �� ��ǰ�� ������ ����
	        //�׶� want�� hash�� ���°��ִٸ� i++�ؼ� ��������..
	        //�׷����ؼ� �� ������ ������ cnt++���ֱ� i=n ~ i=10+n �ؼ� �̰� 10���� �۾����� ��

	        Map<String, Integer> wantMap = new HashMap<>();
	        for(int i = 0; i < want.length; i++) {
	            wantMap.put(want[i], number[i]);
	        }
	        
	        int answer = 0;
	        int cnt = 0;
	        while(10+cnt <= discount.length) {
	            boolean same = true;
	            Map<String, Integer> discountMap = new HashMap<>();
	            for(int i = cnt; i < 10+cnt; i++) { // 0~10 ������
	                discountMap.put(discount[i], discountMap.getOrDefault(discount[i],0)+1);
	            }
	            for(String product : discountMap.keySet()) {
	                if(wantMap.containsKey(product)) {
	                    if(wantMap.get(product) != discountMap.get(product)) {
	                        same = false;
	                        break; //while�����ΰ��°ǰ�?
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
