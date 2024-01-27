import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            que.add(Integer.parseInt(st.nextToken()));
        }
        int before = que.poll();
        int height = before;
        while (!que.isEmpty()) {
            int cur = que.poll();
            int distance = cur - before;
            if (distance % 2 != 0)
                distance++;
            height = Math.max(height, distance / 2);
            before = cur;
        }
        height = Math.max(height, N - before);
        System.out.println(height);
    }
}
