import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		
		final int INF = 987654321;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] dp = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			for (int j = s; j <= e; j++) {
				set.add(j);
			}
		}
		
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (int i = 2; i <= N; i++) {
			if(i-A >= 0 && !set.contains(i)) dp[i] = Math.min(dp[i], dp[i-A]+1);
			if(i-B >= 0 && !set.contains(i)) dp[i] = Math.min(dp[i], dp[i-B]+1);
		}
		
		System.out.println(dp[N]>=INF?-1:dp[N]);
	}

}
