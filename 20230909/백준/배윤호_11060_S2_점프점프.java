import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE / 10);
		dp[0] = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			int cur = 0;
			int temp = arr[i];
			while (true) {
				cur++;
				if (cur > temp || i + cur >= N)
					break;
				dp[i + cur] = Math.min(dp[i + cur], dp[i] + 1);
			}
		}
		System.out.println(dp[N - 1] == Integer.MAX_VALUE / 10 ? -1 : dp[N - 1]);
	}

}
