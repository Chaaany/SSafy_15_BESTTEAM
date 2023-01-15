import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean[][] pd;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = s.length();
		pd = new boolean[n + 1][n + 1];
		dp = new int[n + 1];
		find(s, n);
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (pd[j][i])
					dp[i] = Math.min(dp[i], dp[j - 1] + 1);
			}
		}
		System.out.println(dp[n]);
	}

	public static void find(String str, int len) {

		for (int start = 1; start <= len; start++) {
			for (int end = start; end <= len; end++) {
				boolean flag = true;

				int s = start - 1;
				int e = end - 1;
				while (s <= e) {
					if (str.charAt(s++) != str.charAt(e--)) {
						flag = false;
						break;
					}
				}
				if (flag)
					pd[start][end] = true;
			}
		}
	}

}
