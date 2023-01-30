import java.io.*;
import java.util.*;

public class BJ_7579_앱 {

	static int N, M;
	static int[] memory, cost;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		memory = new int[N+1];
		cost = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sum+=cost[i];
		}
		
		// i번째까지 고려했을때 j의 비용으로 얻을 수 있는 최대 메모리
		dp = new int[N+1][sum+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= sum; j++) {
				if(j>=cost[i]) {
					// 현재 메모리 + 전번호까지 고려했을 때 중에 현재 비용을 뺀 비용의 최대 메모리
					dp[i][j] = memory[i]+dp[i-1][j-cost[i]];
				}
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
				// 모든 앱을 고려했을 때 dp[N] 기준 처음으로 메모리가 M을 넘는 것이 답(갈수록 비용이 증가하기 때문)
				if(i==N && dp[i][j]>=M) {
					System.out.println(j);
					return;
				}
			}
		}
	}

}
