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

        if(depth == m){ //depth�� ���̶� ������ ���
            for(int i = 0; i < arr.length; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){ // i = 1, i = 2
            if(!visit[i]){ // �迭�� �湮���� �ʾҴ�
                visit[i] = true; // �湮ó�� ��
                arr[depth] = i+1; // ���� ä���
//                System.out.println("depth : " + depth + " // arr[" +depth+"] : " + arr[depth]);
                dfs(depth + 1); // �� �� ��� ��
                visit[i] = false;
            }
        }
    }


}
