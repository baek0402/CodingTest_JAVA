package algo0713;

import java.util.*;
import java.io.*;

public class DFS {

	static int n, m;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n];

        dfs(0);
        System.out.println(sb.toString());
    }

    static void dfs(int depth) {

        if(depth == m){ //depth가 길이랑 같아진 경우
            for(int i = 0; i < arr.length; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){ // i = 1, i = 2
            if(!visit[i]){ // 배열에 방문하지 않았다
                visit[i] = true; // 방문처리 해
                arr[depth] = i+1; // 값을 채우고
//                System.out.println("depth : " + depth + " // arr[" +depth+"] : " + arr[depth]);
                dfs(depth + 1); // 좀 더 깊게 들어가
                visit[i] = false;
            }
        }
    }


}
