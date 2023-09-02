package algo0706;

import java.util.*;
import java.io.*;

public class boj1302_new {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> m = new HashMap<>();
		int max = 0;
		//Map<String, Integer> ans = new TreeMap<>();
		
		while(N-- > 0) {
			String book = br.readLine();
			
			/*
			if(m.containsKey(s)) {
				m.put(s, m.get(s)+1);
			}
			else {
				m.put(s, 1);
			}*/
			m.put(book, m.getOrDefault(book, 0) + 1);
			max = (max > m.get(book) ? max : m.get(book));
		}
		
		String bestBook = "";
        String now = "";
        for (String ans : m.keySet()) {
            if (m.get(ans) == max) {
                if (bestBook != "") {
                    now = ans;
                    if (now.compareTo(bestBook) > 0)
                        continue;
                }
                bestBook = ans;
            }
        }

        System.out.print(bestBook);
	}
}
