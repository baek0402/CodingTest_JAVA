package algo0724;

import java.io.*;
import java.util.*;

public class prog_dir {

	static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
	static int cnt = 0;
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); //AAAAE
		
		for(int i = 0; i < 5; i++) {
			dfs(str, "", i+1);
			System.out.println("return");
			if(flag) break;
		}
		System.out.println(cnt);
		
	}
	
	static void dfs(String word, String str, int len) {
		if(flag) return;
		
        if(len == str.length()) {
            cnt++;
            if(str.equals(word)) {
            	//System.out.println(word);
            	flag = true;
            	return;            	
            }
            if(len == word.length()) return;
        }
         
        for(int i = 0; i < 5; i++) { //AEIOU 다섯개를 도니까?
            if(!flag) {
                str += alpha[i];
                System.out.println(str + " 1 ");
                dfs(word, str, str.length());
                str = str.substring(0, str.length()-1);
                //len -= 1;
                System.out.println(str);
                
            }
        }
    }

}
