package algo0614;
import java.io.*;
import java.util.*;

//bfs����? (������) Ȥ��.. 
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
		//���ĵ� �� �߿��� �ִ��� �߰����� ã�� <- �߰����������� ���� ������
		//1. �߰����� ������ �ٷ� �� (%2�� �ƴϸ� ���߿� ������)
		//2. �߰����� ������, �յ� ������ �߰��� �� �����ŷ� �ϱ�
		
		long sum1 = 0, sum2 = 0;
		int answer = 0;
		int mid_idx = (N / 2)-1; //¦���� 2,3�̰� Ȧ����(5) 2
		if(N % 2 != 0) { //Ȧ���ΰ��� �߾Ӱ��� ��
			System.out.println(arr[mid_idx+1]);
			return;
		}
		else { //¦���� �߰��� ���߿� �ϳ��� ���� (ex. index 2, 3)
			//���� �ε����� ���� ���밪 ���غ���
			for(int i = 0; i < N; i++) {
				sum1 += (Math.abs(arr[mid_idx]-arr[i]));
			}
			
			//ū �ε����� ���� ���밪 ���غ���
			for(int i = 0; i < N; i++) {
				sum2 += (Math.abs(arr[mid_idx+1] - arr[i]));
			}

			if(sum1 >= sum2) answer = arr[mid_idx];
			else answer = arr[mid_idx+1];
		}
		System.out.println(answer);
	}
}
