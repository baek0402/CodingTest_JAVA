package algo0905;

import java.util.*;
import java.io.*;

public class prog_stack3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean solution(String s) {
        Boolean result = true;
        // ')'부터 넣으면 무조건 땡, 
        // '('면 무조건 넣고, ')'를 만나면 빼
        // 그렇게 ()의 짝이 맞는지 확인을 해
        // 1. st.empty가 아니면 땡, 2. 
        
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(st.isEmpty()) {
                if(c == ')') return false;
            }
            
            if(c == '(')
                st.push(c);
            else {//
                st.pop();
            }
        }
        
        if(!st.isEmpty()) return false;
        return result;
    }
}
