
import java.util.*;
import java.io.*;

public class boj1931 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i][0] = a;
			arr[i][1] = b;			
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] < o2[0]) return -1;
				else if(o1[0] > o2[0]) return 1;
				else {
					if(o1[1] > o2[1]) return 1;
					else if(o1[1] < o2[1]) return -1;
					else return 0;
				}
			}
		});

		/*
		11
		1 4
		3 5
		0 6
		5 7
		3 8
		5 9
		6 10
		8 11
		8 12
		2 13
		12 14
		*/
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + ", " + arr[i][1]);
		}
		
		/*
		 * 1. 첫번째 인자가 제일 작은거를 기준으로 접근한다 (0, 6)
		 * 2. 끝나는 시간보다 큰 수중에 가장 작은 수를 선택하여 접근한다 (8, 11)
		 * 3. (12, 14) : 3개
		 * 
		 * 1. (1, 4)로 한번 더..
		 */
		
		while(true) {
			
		}
	}
}
