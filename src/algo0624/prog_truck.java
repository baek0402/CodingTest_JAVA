package algo0624;

import java.util.*;
import java.io.*;

public class prog_truck {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int bridge_length = Integer.parseInt(br.readLine());
		int weight = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		Queue<Position> q = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			 //2, 2, 2, 2, 1, 1, 1, 1, 1
		}

		//5, 5, 10, [2,2,2,2,1,1,1,1,1]
		
		// 젤 처음 큐 넣고 
		int i = 0, idx = 0;
		int cnt = 0;
		int now_weight = arr[i];
		q.offer(new Position(arr[i], idx));
		while(true) {
			//if() 탈출조건
			
			if(now_weight + arr[i++] > weight) { //
				if(idx >= 6) {
					now_weight -= arr[i];
				}
				cnt++;
				idx++;
				q.poll();
				q.offer(new Position(arr[i], idx));
			}
			else { //다음값에 대해 .. 작거나 같으면
				q.poll();
				q.offer(new Position(arr[i++], idx++));
				q.offer(new Position(arr[i], idx));
				cnt++;
			}
		}
	}
}

