import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4097_SuIk {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			int[] dp = new int[N];
			dp[0] = Integer.parseInt(br.readLine());
			int max = dp[0];
			for (int i = 1; i < N; i++) {
				int cur = Integer.parseInt(br.readLine());
				dp[i] = Math.max(dp[i - 1] + cur, cur);
				max = Math.max(dp[i], max);
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}

}
