import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            long a = pq.poll();
            long b = pq.poll();
            pq.add(a + b);
            pq.add(a + b);
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        System.out.println(ans);
    }

}
