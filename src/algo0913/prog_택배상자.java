package algo0913;
import java.util.*;

public class prog_�ù���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	class Solution {
		public int solution(int[] order) {
			int answer = 0;
		
			Deque<Integer> dq = new ArrayDeque<>();
			Stack<Integer> sub = new Stack<>();
		
			for(int i = 0; i < order.length; i++){
				dq.offer(i+1);
			}
		
			int tmp = 0;
			for(int i = 0; i < order.length; i++){
				while(true){
					if(tmp > order[i]){
						if(sub.peek() == order[i]){
							tmp = sub.peek();
							sub.pop();
							answer++;
							break;
						} else {
							return answer;
						}
					}
					else if(!dq.isEmpty()){
						if(dq.peek() == order[i]){
							tmp = dq.peek();
							dq.poll();
							answer++;
							break;
						} else {
							sub.push(dq.poll());
						}
					}
				}
			}
		
			return answer;
		}
	}
}
