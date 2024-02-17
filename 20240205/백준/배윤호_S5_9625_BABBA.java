import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[][] dp = new int[K + 1][2];
        dp[0][0] = 1;
        for (int i = 1; i < K + 1; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][1] + dp[i - 1][0];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[K][0] + " " + dp[K][1]);
        System.out.println(sb);
    }

}
