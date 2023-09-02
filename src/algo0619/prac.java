package algo0619;

import java.util.*;
import java.io.*;

class prac{
	
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for (int t = 0; t < test_case; t++) { //tc �ޱ�
            Deque<Character> dq = new ArrayDeque<>(); //�� ����
            StringBuilder sb = new StringBuilder();


            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" "); //�ڸ���
            char point = arr[0].charAt(0);
            dq.offerFirst(point); //ù ��° �� �̸� �ֱ�

            /*
            while(st.hasMoreTokens()){ //��ū �� ������ �ݺ� ���� �Ŵϱ�
                char c = st.nextToken().charAt(0);
                if (c < point) { //�߽ɰ��� �� ũ��
                    dq.offerFirst(c); //���ʿ� �ְ�
                } else {
                    dq.offerLast(c); //�ƴϸ� ����������
                }
            }
            */

            for (int i = 1; i < n; i++) {
                if (arr[i].charAt(0) > dq.peekFirst()) { 
                    dq.offerLast(arr[i].charAt(0)); //���ʿ� �ְ�
                } else {
                    dq.offerFirst(arr[i].charAt(0)); //�ƴϸ� �����ʿ�
                }
            }

            /*
            for(char c : dq){
                sb.append(c);
                //������̶� for-each�� �ȵǳ�
            }
            */

            while (!dq.isEmpty()) { //÷���� ������ �ְ�
                sb.append(dq.pollFirst());
            }

            System.out.println(sb); //���
        }
    }
}