package algo0901;

import java.util.*;
import java.io.*;

public class boj1620 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		Map<Integer, String> map2 = new HashMap<>();
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			map.put(str, i);
			map2.put(i, str);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String str = br.readLine();

			//입력받은값이 숫자인지, 문자인지
			if(str.charAt(0)-'0' >= 1 && str.charAt(0)-'0' <= 9) {
				int num = Integer.parseInt(str);
				
				//value에 해당하는 key값을 for문없이 어떻게 찾지?
				/*for(String ans : map.keySet())
					if(map.get(ans) == num)
						sb.append(ans + "\n");*/
				sb.append(map2.get(num));
			}
			else {
				sb.append(map.get(str) + "\n");
			}
		}
		
		System.out.println(sb);
	}

}
