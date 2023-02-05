import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			int[] files = new int[K + 1];
			int[][] dp = new int[K + 1][K + 1];
			int[] sum = new int[K + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i < K + 1; i++) {
				files[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i < K + 1; i++) {
				sum[i] = sum[i - 1] + files[i];
			}

			for (int n = 1; n <= K; n++) {
				for (int from = 1; from + n <= K; from++) {
					int to = from + n;
					dp[from][to] = Integer.MAX_VALUE;
					for (int divide = from; divide < to; divide++) {
						dp[from][to] = Math.min(dp[from][to],
								dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
					}
				}
			}
			sb.append(dp[1][K] + "\n");
		}
		System.out.println(sb);

	}

}
