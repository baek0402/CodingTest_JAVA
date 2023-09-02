package algo0721;

import java.util.*;
import java.io.*;

public class boj2573_ans {

    static int n, m;
    static int[][] mat;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        mat= new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 해가 지날때마다 녹는거 표현
        int answer = 0;
        boolean flag = true;
        while (true){
            if(!check()){ // 빙산 하나하나가 하나라도 존재하면
                flag = false;
                break;
            }
            visit = new boolean[n][m];
            answer++;
            melt(); // 녹는거 표현
            int berg = 0;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(mat[i][j] > 0 && !visit[i][j]){
                        berg++;
                        bfs(i, j); // 빙산 개수
                    }
                }
            }
            if(berg >= 2){
                break;
            }
        }

        if(!flag){
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
    static boolean check(){
        for(int i = 0; i <n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static void bfs(int r, int c){
        visit[r][c] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0; i < 4; i++){
                int nr = now[0] + dx[i];
                int nc = now[1] + dy[i];
                if(nr < 0 || nc < 0 || nr >= n || nc >= m || visit[nr][nc] || mat[nr][nc] == 0){
                    continue;
                }
                q.offer(new int[] {nr, nc});
                visit[nr][nc] = true;
            }
        }
//        for(int i = 0; i < 4; i++){
//            int nr = r + dx[i];
//            int nc = c + dy[i];
//            if(nr < 0 || nc < 0 || nr >= n || nc >= m || visit[nr][nc] || mat[nr][nc] == 0){
//                continue;
//            }
//            dfs(nr, nc);
//        }
    }

//    static void melt(){
//        int[][] tmp = new int[n][m];
//
//        for(int i = 0; i < n ; i++){
//            for(int j = 0; j < m; j++){
//                if(mat[i][j] > 0){
//                    int sea = seaCnt(i, j, 0);
//                    if(mat[i][j] < sea){
//                        tmp[i][j] = 0;
//                    } else {
//                        tmp[i][j] = mat[i][j] - sea;
//                    }
//                }
//            }
//        }
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                mat[i][j] = tmp[i][j];
//            }
//        }
//    }

    static void melt(){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit2 = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] > 0) {
                    visit2[i][j] = true;
                    q.offer(new int[] {i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] now = q.poll();
            int sea = 0;
            for(int i = 0; i < 4; i++){
                int nr = now[0] + dx[i];
                int nc = now[1] + dy[i];
                if(nr < 0 || nc < 0 || nr >= n || nc >= m || visit2[nr][nc]){
                    continue;
                }
                if(mat[nr][nc] == 0){
                    sea++;
                }
            }
            if(mat[now[0]][now[1]] < sea){
                mat[now[0]][now[1]] = 0;
            } else {
                mat[now[0]][now[1]] -= sea;
            }
        }
    }

    static int seaCnt(int r, int c, int sea){
        for(int i = 0; i < 4; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];
            if(nr < 0 || nc < 0 || nr >= n || nc >= m){
                continue;
            }
            if(mat[nr][nc] == 0) {
                sea++;
            }
        }
        return sea;
    }
}