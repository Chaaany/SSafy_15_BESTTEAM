import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int INF = 987654321;
		
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[N+1];
		int[] dp = new int[N+1];
		st = new StringTokenizer(br.readLine());
				
		for (int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(dp, INF);
		dp[1] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= map[i]; j++) {
				if(i+j > N) break;
				dp[i+j] = Math.min(dp[i+j], dp[i]+1);
			}
		}
		
		System.out.println(dp[N]>=INF?-1:dp[N]);
	}

}
