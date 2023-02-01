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
		int[][] dp = new int[N + 1][10001];
		int[] m = new int[N + 1];
		int[] c = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < 10001; j++) {
				if (j - c[i] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + m[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		for (int i = 1; i < 10001; i++) {
			if (dp[N][i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}

}
