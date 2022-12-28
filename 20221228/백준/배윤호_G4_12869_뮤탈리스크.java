import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int min = 100;
	static int N = 0;
	static int[][] pattern = { { -9, -3, -1 }, { -9, -1, -3 }, { -3, -9, -1 }, { -3, -1, -9 }, { -1, -9, -3 },
			{ -1, -3, -9 } };
	static int[][][] dp = new int[61][61][61];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] SCV = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			SCV[i] = Integer.parseInt(st.nextToken());
		}
		attack(SCV, 0);
		System.out.println(min);
	}

	private static void attack(int[] SCV, int count) {
		if (count >= min)
			return;
		int S1 = SCV[0];
		int S2 = SCV[1];
		int S3 = SCV[2];
		if (dp[S1][S2][S3] <= count && dp[S1][S2][S3] != 0)
			return;
		dp[S1][S2][S3] = count;

		if (S1 <= 0 && S2 <= 0 && S3 <= 0) {
			min = Math.min(min, count);
			return;
		}
		for (int d = 0; d < 6; d++) {
			int[] temp = new int[3];
			temp[0] = Math.max(SCV[0] + pattern[d][0], 0);
			temp[1] = Math.max(SCV[1] + pattern[d][1], 0);
			temp[2] = Math.max(SCV[2] + pattern[d][2], 0);
			attack(temp, count + 1);
		}
	}

}
