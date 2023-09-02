package algo0614;
import java.io.*;
import java.util.*;

//bfs접근? (일차원) 혹은.. 
public class boj18310 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {			
			arr[i] = Integer.parseInt(st.nextToken());			
		}
		Arrays.sort(arr);
	
		//1,5,7,9 
		//정렬된 수 중에서 최대한 중간값을 찾기 <- 중간점기준으로 가장 가까운애
		//1. 중간값이 있으면 바로 답 (%2가 아니면 둘중에 작은값)
		//2. 중간값이 없으면, 앞뒤 숫자중 중간과 더 가까운거로 하기
		
		long sum1 = 0, sum2 = 0;
		int answer = 0;
		int mid_idx = (N / 2)-1; //짝수면 2,3이고 홀수면(5) 2
		if(N % 2 != 0) { //홀수인경우는 중앙값이 답
			System.out.println(arr[mid_idx+1]);
			return;
		}
		else { //짝수면 중간값 둘중에 하나가 정답 (ex. index 2, 3)
			//작은 인덱스의 길이 절대값 구해보기
			for(int i = 0; i < N; i++) {
				sum1 += (Math.abs(arr[mid_idx]-arr[i]));
			}
			
			//큰 인덱스의 길이 절대값 구해보기
			for(int i = 0; i < N; i++) {
				sum2 += (Math.abs(arr[mid_idx+1] - arr[i]));
			}

			if(sum1 >= sum2) answer = arr[mid_idx];
			else answer = arr[mid_idx+1];
		}
		System.out.println(answer);
	}
}
