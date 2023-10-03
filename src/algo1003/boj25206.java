package algo1003;

import java.io.*;
import java.util.*;

public class boj25206 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double sum = 0;
		double scoreSum = 0;
		int cnt = 0;
		for(int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String lecutre = st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			
			if(grade.equals("A+")) sum = sum + (score * 4.5);
			else if(grade.equals("A0")) sum = sum + (score * 4.0);
			else if(grade.equals("B+")) sum = sum + (score * 3.5);
			else if(grade.equals("B0")) sum = sum + (score * 3.0);
			else if(grade.equals("C+")) sum = sum + (score * 2.5);
			else if(grade.equals("C0")) sum = sum + (score * 2.0);
			else if(grade.equals("D+")) sum = sum + (score * 1.5);
			else if(grade.equals("D0")) sum = sum + (score * 1.0);
			else if(grade.equals("F")) sum = sum + (score * 0.0);
			else if(grade.equals("P")) continue;
			scoreSum += score;
		}
		double result = sum / scoreSum;
		System.out.println(String.format("%.6f", result));
	}

}
