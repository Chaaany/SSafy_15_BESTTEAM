import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i < N + 1; i++) {
            dp[i][0] = dp[i - 1][0];
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j - 1] + arr[i - 1];
            }
            for (int j = 1; j <= M && i > j; j++) {
                dp[i][0] = Math.max(dp[i][0], dp[i - j][j]);
            }
        }

        // for(int i=0; i<N+1; i++){
        // for(int j=0; j<M+1; j++){
        // System.out.print(dp[i][j]+" ");
        // }
        // System.out.println();
        // }

        System.out.println(dp[N][0]);
    }

}
