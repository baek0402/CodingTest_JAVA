package algo0912;

import java.util.*;

public class prog_�ĺ�Ű {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/* �� �ڵ�ƴ�
	class Solution {
		// �ĺ�Ű -> ���ϼ��� �ּҼ� ���� ����
		// �������� �̸� ������ ���ÿ� ����ϸ� �����̼� ��� Ʃ�� �ĺ� ����
		// relation 2���� ���ڿ� �迭
		// �ĺ�Ű�� ������ ���
		// �÷��� �ִ� 8��
		// row 20��

		// �ĺ�Ű�� ������ ��� ���� ����
		// ���ϼ��� ����� �ֵ鸸 ����
		// ���ο� �ĺ�Ű ã�������� -> �ּҼ� üũ��
		static ArrayList<String> al = new ArrayList<>();
		static ArrayList<Integer> al2;
	
		static void find(int start, int depth, int end, boolean[] visit, String[][] relation){
			
			if(depth == end){
				al2 = new ArrayList<>();
				String key = "";
				for(int i = 0; i < visit.length; i++){
					if(visit[i]){
						key+=String.valueOf(i);
						al2.add(i);
					}
				}
	
				HashMap<String, Integer> hm = new HashMap<>();
				for(int i = 0; i < relation.length; i++){
					String str = "";
					for(int j : al2){
						str += relation[i][j];
					}
					if(hm.containsKey(str)){
						return;
					} else {
						hm.put(str, 0);
					}
				}
	
				for(String tmp : al){
					int cnt = 0;
					for(int i = 0; i < key.length(); i++){
						String tmpKey = String.valueOf(key.charAt(i));
						if(tmp.contains(tmpKey)){ // �ּҼ� üũ
							cnt++;
						}
					}
					if(cnt == tmp.length()){
						return;
					}
				}
				al.add(key);
			}
	
			for(int i = start; i < visit.length; i++){
				if(!visit[i]){
					visit[i] = true;
					find(i, depth + 1, end, visit, relation);
					visit[i] = false;
				}
			}
		}

		public int solution(String[][] relation) {
			int answer = 0;
			boolean[] visit;

			for(int i = 0; i < relation[0].length; i++){
				visit = new boolean[relation[0].length];
				find(0, 0, i+1, visit, relation);
			}

			answer = al.size();

			return answer;
		}
	}
	*/
}
