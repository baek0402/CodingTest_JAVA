package algo0901;

import java.util.*;
import java.io.*;

public class boj11723 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> al = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int num = 0;
			
			if(str.equals("add")) {
				num = Integer.parseInt(st.nextToken());
				al.add(num);
			}
			else if(str.equals("check")) {
				num = Integer.parseInt(st.nextToken());
				
				if(al.contains(num)) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			}
			else if(str.equals("remove")) {
				num = Integer.parseInt(st.nextToken());
				
				if(!al.contains(num)) 
					continue;
				
				al.remove(al.indexOf(num));
			}
			else if(str.equals("toggle")) {
				num = Integer.parseInt(st.nextToken());
				
				if(al.contains(num))
					al.remove(al.indexOf(num));
				else al.add(num);
			}
			else if(str.equals("all")) {
				al.clear();
				
				for(int i = 1; i <= 20; i++) {
					al.add(i);
				}
			}
			else if(str.equals("empty")) {
				al.clear();
			}
		}
		
		System.out.println(sb);
	}

}
