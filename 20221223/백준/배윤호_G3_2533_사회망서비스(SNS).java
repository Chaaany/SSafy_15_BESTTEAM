import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] v;
	static List<Integer>[] SNS;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][2];
		v = new boolean[N + 1];
		SNS = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			SNS[i] = new ArrayList<Integer>();
		}
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			SNS[a].add(b);
			SNS[b].add(a);
		}
		find(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	private static void find(int person) {
		v[person] = true;
		dp[person][0] = 0;
		dp[person][1] = 1;
		for (int friend : SNS[person]) {
			if (!v[friend]) {
				find(friend);
				dp[person][0] += dp[friend][1];
				dp[person][1] += Math.min(dp[friend][0], dp[friend][1]);
			}
		}
	}
}
