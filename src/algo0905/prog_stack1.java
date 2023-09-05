package algo0905;

import java.util.*;
import java.io.*;

public class prog_stack1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] solution(int []arr) {
        Deque<Integer> st = new ArrayDeque<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(st.isEmpty()) {
                st.offerLast(arr[i]);
                continue;
            }
            if(st.peekLast() == arr[i]) {
                //st.offerLast(arr[i]);
                continue;
            }
            st.offerLast(arr[i]);
        }
        
        int i = 0;
        int[] answer = new int[st.size()];
        while(!st.isEmpty()) {
            answer[i] = st.pollFirst();
            i++;
        }
        
        return answer;
    }
}
