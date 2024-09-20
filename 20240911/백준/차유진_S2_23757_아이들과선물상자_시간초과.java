import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> giftList = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            giftList.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> children = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < M; i++) {
            children.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < children.size(); i++) {
            int n = children.poll();
            List<Integer> list = new ArrayList<>();
            boolean flag = false;
            while(!giftList.isEmpty() && !flag) {
                int m = giftList.poll();
                if (m >= n) {
                    list.add(m-n);
                    flag = true;
                }
                else list.add(m);
            }
            if (!flag) {
                System.out.println(0);
                return;
            }
            giftList.addAll(list);
        }
        System.out.println(1);
    }
}
