package algo0904;

import java.util.*;
import java.io.*;

public class prog_heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int[] scoville, int K) {
        //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        int cnt = 0;
        while(pq.size() > 1) {
            //pq에 하나만 남았고, 
            if(pq.peek() >= K) return cnt; //중간중간 젤 앞 값 체크해주는거임!
            
            int n1 = pq.poll();
            int n2 = pq.poll();
            int sum = n1 + n2 * 2;

            cnt++;            
            pq.offer(n1 + (n2 * 2)); //일단 무조건 넣어
        }
        
        if(pq.peek() > K) return cnt;
        return -1;
    }
}
