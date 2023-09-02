package algo0628;

import java.io.*;
import java.util.*;

public class boj11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				int a = Math.abs(o1);
				int b = Math.abs(o2);
				
				if(Math.abs(o1) == Math.abs(o2)) {
					if(o1 > o2) return 1; //자리바꿔
					else if(o1 < o2) return -1;
					else return 0;
				} else if (Math.abs(o1) > Math.abs(o2)) {
					return 1; // 자리바꿔					
				} else {
					return -1;
				}
			}
			
			/*
			 * @Override
                    public int compare(Integer o1, Integer o2) {
                        int a = Math.abs(o1); 
                        int b = Math.abs(o2);
                        if (a == b) { // 절댓값이 같으면
                            return o1 > o2 ? 1 : -1; //절댓값 같은 수들은 기존 값으로 오름차순
                        } else { // 절댓값 다르면
                            return a - b; // 절댓값으로 오름차순
                        }
                    }
			 */
			
		}); //오름차순 정렬

		StringBuilder sb = new StringBuilder();
		for(int i=0; i < N; i++) {			
			int num = Integer.parseInt(br.readLine());			
			
			/*
			 * 수를 넣을 때 절대값으로 비교해서 넣음
			 * 근데 같은 수 일때는 오름차순
			 * 1. 일단 절대값으로 넣고나서 2. poll하면서 출력 
			 * -1 1 -2 2
			 * 
			 * 근데이러면 걍 넣은순서대로 나옴 ㅜ ㅜ 1 1 -1 -1 2 2 -2 -2 이렇게
			 * 
			 * 1. 절대값으로 비교하고
			 * 2. 절대값이 같으면, 둘이 절대값 풀고 비교하기...........?
			 * 
			 * 
			 */
			
			
			boolean flag = true;
			if(num != 0) {
				pq.offer(num);
			}
			else {
				//0이 주어진 만큼 스택의 수 출력하기
				if(pq.isEmpty()) {
					System.out.println(0);
					continue;
				}
				System.out.println(pq.poll());
			}
		}
	}
}

