import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken()) - 1;
        int[] pos = new int[N];
        int[] fuel = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pos[i] = Integer.parseInt(st1.nextToken());
            fuel[i] = Integer.parseInt(st2.nextToken());
        }
        PriorityQueue<Integer> connectedcar = new PriorityQueue<>();
        connectedcar.add(S + 1);
        Queue<Integer> que = new LinkedList<>();
        que.add(S);
        boolean[] v = new boolean[N];
        v[S] = true;
        while (!que.isEmpty()) {
            int cur = que.poll();
            int left = pos[cur] - fuel[cur];
            int right = pos[cur] + fuel[cur];
            for (int i = cur; i >= 0; i--) {
                if (pos[i] < left) {
                    break;
                }
                if (!v[i]) {
                    que.add(i);
                    connectedcar.add(i + 1);
                    v[i] = true;
                }
            }
            for (int i = cur; i < N; i++) {
                if (pos[i] > right) {
                    break;
                }
                if (!v[i]) {
                    que.add(i);
                    connectedcar.add(i + 1);
                    v[i] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!connectedcar.isEmpty()) {
            sb.append(connectedcar.poll() + " ");
        }
        System.out.println(sb);

    }

}
