package algo0926;

public class prog_피로도 {
    static int answer = 0;
    static int cnt = 0;
    static boolean[] visited;
    static boolean success = false;
    class Solution {
	    
	    public int solution(int k, int[][] dungeons) {
	        //백트래킹인가
	        visited = new boolean[dungeons.length];
	        
	        for(int i = 0; i < dungeons.length; i++) {
	            dfs(0, k, dungeons); //depth, 현재체력, idx, 배열
	        }
	        
	        return answer;
	    }
	    
	    public void dfs(int depth, int k, int[][] dungeons) {
	        //if(success) return;
	        
	        if(depth == dungeons.length) {
	            System.out.println(k + "," + depth);
	            answer = Math.max(cnt, answer);
	            success = true;
	            return;
	        }
	                
	        for(int i = 0; i < dungeons.length; i++) { //3
	            //1. 피로도 확인하기
	            if(k >= dungeons[i][0] && !visited[i]) {
	                k -= dungeons[i][1]; //피로도계산
	                cnt++;
	                visited[i] = true;
	                dfs(depth+1, k, dungeons);
	                cnt--;
	                k += dungeons[i][1];
	                visited[i] = false;
	            }
	            answer = Math.max(cnt, answer);
	        }
	    }
	}
}
