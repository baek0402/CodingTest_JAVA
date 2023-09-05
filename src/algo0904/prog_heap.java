package algo0904;

import java.util.*;
import java.io.*;

public class prog_heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int[] scoville, int K) {
        //���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        int cnt = 0;
        while(pq.size() > 1) {
            //pq�� �ϳ��� ���Ұ�, 
            if(pq.peek() >= K) return cnt; //�߰��߰� �� �� �� üũ���ִ°���!
            
            int n1 = pq.poll();
            int n2 = pq.poll();
            int sum = n1 + n2 * 2;

            cnt++;            
            pq.offer(n1 + (n2 * 2)); //�ϴ� ������ �־�
        }
        
        if(pq.peek() > K) return cnt;
        return -1;
    }
}
