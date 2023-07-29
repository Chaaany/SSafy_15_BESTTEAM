import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] army = new int[N+1];
		int[] dp = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			army[i] = Integer.parseInt(st.nextToken());
		}
		
		// 최장 감소 수열
		int max = 0;
		Arrays.fill(dp, 1);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if(army[i] < army[j])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(N-max);
	}

}
