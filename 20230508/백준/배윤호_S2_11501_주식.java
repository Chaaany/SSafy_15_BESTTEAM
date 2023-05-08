import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                stack.add(Integer.parseInt(st.nextToken()));
            }
            long max = stack.pop();
            long profit = 0;
            while (!stack.isEmpty()) {
                long next = stack.pop();
                if (next > max) {
                    max = next;
                } else {
                    profit += max - next;
                }
            }
            sb.append(profit).append("\n");
        }
        System.out.println(sb);
    }

}
