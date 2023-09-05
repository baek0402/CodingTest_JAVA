package algo0904;

import java.util.*;
import java.io.*;

public class prog_hash1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();

        /*
        for (String phoneNumber : phone_book) {
            map.put(phoneNumber, 1);
        }
        */
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], 1);
        }

        /*
        for(String str : map.keySet()) {
            for(String str2 : map.keySet()) { //여기서 다음값부터 보고싶음
                if(str.compareTo(str2) >= 0) continue;
                if(str2.startsWith(str)) return false;
            }
        }
        */
        //각 전화번호를 돌면서 접두어인지 containsKey를 해본대
        for(String str : phone_book) {
            for(int i = 1; i < str.length(); i++) {
                String prefix = str.substring(0, i);
                if(map.containsKey(prefix)) {
                    return false;
                }
            }
        }
        
        return answer;
    }
}
