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
					if(o1 > o2) return 1; //�ڸ��ٲ�
					else if(o1 < o2) return -1;
					else return 0;
				} else if (Math.abs(o1) > Math.abs(o2)) {
					return 1; // �ڸ��ٲ�					
				} else {
					return -1;
				}
			}
			
			/*
			 * @Override
                    public int compare(Integer o1, Integer o2) {
                        int a = Math.abs(o1); 
                        int b = Math.abs(o2);
                        if (a == b) { // ������ ������
                            return o1 > o2 ? 1 : -1; //���� ���� ������ ���� ������ ��������
                        } else { // ���� �ٸ���
                            return a - b; // �������� ��������
                        }
                    }
			 */
			
		}); //�������� ����

		StringBuilder sb = new StringBuilder();
		for(int i=0; i < N; i++) {			
			int num = Integer.parseInt(br.readLine());			
			
			/*
			 * ���� ���� �� ���밪���� ���ؼ� ����
			 * �ٵ� ���� �� �϶��� ��������
			 * 1. �ϴ� ���밪���� �ְ��� 2. poll�ϸ鼭 ��� 
			 * -1 1 -2 2
			 * 
			 * �ٵ��̷��� �� ����������� ���� �� �� 1 1 -1 -1 2 2 -2 -2 �̷���
			 * 
			 * 1. ���밪���� ���ϰ�
			 * 2. ���밪�� ������, ���� ���밪 Ǯ�� ���ϱ�...........?
			 * 
			 * 
			 */
			
			
			boolean flag = true;
			if(num != 0) {
				pq.offer(num);
			}
			else {
				//0�� �־��� ��ŭ ������ �� ����ϱ�
				if(pq.isEmpty()) {
					System.out.println(0);
					continue;
				}
				System.out.println(pq.poll());
			}
		}
	}
}

