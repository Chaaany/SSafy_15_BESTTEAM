import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }
        int MaeSoo = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N - 1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        while (true) {
            int temp = pq.poll();
            if (dasom > temp)
                break;
            pq.add(--temp);
            dasom++;
            MaeSoo++;
        }
        System.out.println(MaeSoo);
    }

}
