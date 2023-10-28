import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1000000);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = a; j <= b; j++) {
                dp[j] = -1;
            }
        }
        if (dp[A] != -1) {
            dp[A] = 1;
        }
        if (dp[B] != -1) {
            dp[B] = 1;
        }
        int start = Math.min(A, B);
        for (int i = start; i < N + 1; i++) {
            if (dp[i] == -1)
                continue;
            if (i - A > 0) {
                if (dp[i - A] != 1000000 && dp[i - A] > 0) {
                    dp[i] = Math.min(dp[i], dp[i - A] + 1);
                }
            }
            if (i - B > 0) {
                if (dp[i - B] != 1000000 && dp[i - B] > 0) {
                    dp[i] = Math.min(dp[i], dp[i - B] + 1);
                }
            }
        }
        if (dp[N] == 1000000)
            dp[N] = -1;
        System.out.println(dp[N]);

    }

}
