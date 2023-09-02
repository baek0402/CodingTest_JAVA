package algo0619;

import java.util.*;
import java.io.*;

class prac{
	
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for (int t = 0; t < test_case; t++) { //tc 받기
            Deque<Character> dq = new ArrayDeque<>(); //덱 선언
            StringBuilder sb = new StringBuilder();


            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" "); //자르고
            char point = arr[0].charAt(0);
            dq.offerFirst(point); //첫 번째 값 미리 넣기

            /*
            while(st.hasMoreTokens()){ //토큰 더 없으면 반복 끝낼 거니까
                char c = st.nextToken().charAt(0);
                if (c < point) { //중심값이 더 크면
                    dq.offerFirst(c); //왼쪽에 넣고
                } else {
                    dq.offerLast(c); //아니면 오른쪽으로
                }
            }
            */

            for (int i = 1; i < n; i++) {
                if (arr[i].charAt(0) > dq.peekFirst()) { 
                    dq.offerLast(arr[i].charAt(0)); //왼쪽에 넣고
                } else {
                    dq.offerFirst(arr[i].charAt(0)); //아니면 오른쪽에
                }
            }

            /*
            for(char c : dq){
                sb.append(c);
                //양방향이라 for-each문 안되나
            }
            */

            while (!dq.isEmpty()) { //첨부터 끝까지 넣고
                sb.append(dq.pollFirst());
            }

            System.out.println(sb); //출력
        }
    }
}