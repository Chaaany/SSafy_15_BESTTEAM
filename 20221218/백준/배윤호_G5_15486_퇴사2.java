import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] counsel = new int[N + 2][2];
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			counsel[i][0] = Integer.parseInt(st.nextToken());
			counsel[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N + 2];
		int max = -1;
		for (int i = 1; i < N + 1; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}

			int temp = i + counsel[i][0];
			if (temp < N + 2) {
				dp[temp] = Math.max(max + counsel[i][1], dp[temp]);
			}

		}
		for (int i = 0; i < N + 2; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);

	}

}
