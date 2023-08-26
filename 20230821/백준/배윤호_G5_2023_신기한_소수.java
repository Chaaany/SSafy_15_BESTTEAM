import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        find(0, N);
        System.out.println(sb);
    }

    public static void find(int output, int n) {
        if (n == 0) {
            if (check(output))
                sb.append(output).append("\n");
            return;
        }
        for (int i = 0; i < 10; i++) {
            int next = output * 10 + i;
            if (check(next))
                find(next, n - 1);
        }
    }

    public static boolean check(int num) {
        if (num < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

}
