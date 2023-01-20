import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11049_RowColMultipleOrder {

	static int N;
	static int r, c;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		dp = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				dp[i][j] = 1000;
			}

		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; i + j < N; j++) {
				calcul(j, i + j);
			}
		}

		System.out.println(dp[0][N - 1]);

	}

	public static void calcul(int start, int end) {
		for (int i = start; i < end; i++) {
			// A*B => a*b b*b b*c
			int cost = dp[start][i] + dp[i + 1][end] + arr[start][0] * arr[i][1] * arr[end][1];
			dp[start][end] = Math.min(dp[start][end], cost);
		}
	}

}
