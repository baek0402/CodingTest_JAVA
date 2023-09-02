package algo0706;

import java.util.*;
import java.io.*;

public class boj1302 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> m = new HashMap<>();
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
		}
		
		//for문돌면서 value값이 가장 높은거..다시찾기?
		/*int max = 0;
		String answer = "";
		
		for(String key : m.keySet()) {
			max = (max > m.get(key) ? max : m.get(key));			
		}
		
		//value가 max인 애들을 다시 TreeMap에 넣어?..
		for(String key : m.keySet()) {
			if(m.get(key) == max) {
				ans.put(key, max);
			}
		}
		
		//그럼 거기서 다시 젤 앞 값만 빼..
		for(String s : ans.keySet()) {
			System.out.println(s);
			return; //젤 앞 값만 뺄거니까..
		}*/
		
		//더 나은방법1. map을 가지고 list를 만들어서 value가 가장 큰 값을 빼는 방법
		List<String> ans = new ArrayList<>(m.keySet());
		Collections.sort(ans);
		
		int max = 0;
		String answer = "";
		for(String s : ans) {
			if(m.get(s) > max) {
				max = m.get(s);
				answer = s;
			}
		}
		
		System.out.println(answer);
		
		/* 이거는 글자 compareTo 이용해서 젤 앞의 값 빼는거가튼데
		 * 그리고 max는 값 넣으면서 미리 구하기
		 * String bestBook = null;
        String now;
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == max) {
                if (bestBook != null) {
                    now = entry.getKey();
                    if (now.compareTo(bestBook) > 0)
                        continue;
                }
                bestBook = entry.getKey();
            }
        }

        System.out.print(bestBook);
		 */
	}

}
