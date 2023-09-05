package algo0905;

import java.util.*;
import java.io.*;

public class prog_stack3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean solution(String s) {
        Boolean result = true;
        // ')'���� ������ ������ ��, 
        // '('�� ������ �ְ�, ')'�� ������ ��
        // �׷��� ()�� ¦�� �´��� Ȯ���� ��
        // 1. st.empty�� �ƴϸ� ��, 2. 
        
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
