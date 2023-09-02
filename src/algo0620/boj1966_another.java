package algo0620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1966_another {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            //������ ����
            int n = Integer.parseInt(st.nextToken());
            //�ñ��� ������ �ε���
            int m = Integer.parseInt(st.nextToken());

            Queue<Document> que = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            //ť�� ���� �ֱ�, �����鼭 �߿䵵
            for (int i = 0; i < n; i++) {
                que.offer(new Document(i, Integer.parseInt(st.nextToken())));
            }

            //���ϴ� �ε��� ���� ���ö����� ã��
            int cnt = 0;
            while (true) {
                Document document = que.poll();
                boolean flag = false;

                //���ݺ��� �� ū �߿䵵�� �ִ��� �Ǵ�
                for (Document doc : que) {
                    //���� �������� �� ū �߿䵵�� �ִٸ� flag true�� �ٲٰ� for�� Ż��
                    if (doc.num > document.num) {
                        flag = true;
                        break;
                    }
                }

                //���� �������� �߿䵵�� ���� ���� �ִٴ� ���̹Ƿ� �ش� ������ �ִ� ������ �տ� ������ ���� �ֱ�
                if (flag) {
                    que.offer(document);
                }
                //���� ������ ���� �߿䵵�� ���ٴ� ���̹Ƿ� �ñ��� ������ �ε����� ������ Ȯ�� �ƴ϶�� cnt++
                else {
                    cnt++;
                    if (document.idx == m) break;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}

class Document {
    int idx, num;

    public Document(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}
