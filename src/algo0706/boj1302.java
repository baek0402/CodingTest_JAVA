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
		
		//for�����鼭 value���� ���� ������..�ٽ�ã��?
		/*int max = 0;
		String answer = "";
		
		for(String key : m.keySet()) {
			max = (max > m.get(key) ? max : m.get(key));			
		}
		
		//value�� max�� �ֵ��� �ٽ� TreeMap�� �־�?..
		for(String key : m.keySet()) {
			if(m.get(key) == max) {
				ans.put(key, max);
			}
		}
		
		//�׷� �ű⼭ �ٽ� �� �� ���� ��..
		for(String s : ans.keySet()) {
			System.out.println(s);
			return; //�� �� ���� ���Ŵϱ�..
		}*/
		
		//�� �������1. map�� ������ list�� ���� value�� ���� ū ���� ���� ���
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
		
		/* �̰Ŵ� ���� compareTo �̿��ؼ� �� ���� �� ���°Ű�ư��
		 * �׸��� max�� �� �����鼭 �̸� ���ϱ�
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
