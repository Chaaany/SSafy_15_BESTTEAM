import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pqPlus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> pqMinus = new PriorityQueue<>();
        long ans = 0;
        for (int i = 0; i < N; i++) {
            Long temp = Long.parseLong(br.readLine());
            if (temp > 0) {
                pqPlus.add(temp);
            } else {
                pqMinus.add(temp);
            }
        }
        while (pqPlus.size() > 1) {
            long a = pqPlus.poll();
            long b = pqPlus.poll();
            if (a == 1 || b == 1) {
                ans += a + b;
            } else {
                ans += a * b;
            }
        }
        if (!pqPlus.isEmpty()) {
            ans += pqPlus.poll();
        }
        while (pqMinus.size() > 1) {
            ans += pqMinus.poll() * pqMinus.poll();
        }
        if (!pqMinus.isEmpty()) {
            ans += pqMinus.poll();
        }
        System.out.println(ans);
    }

}
