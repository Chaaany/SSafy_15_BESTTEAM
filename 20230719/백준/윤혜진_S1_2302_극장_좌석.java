import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[N+1];
		int[] dp = new int[41];
		
		for (int i = 0; i < M; i++) {
			int seat = Integer.parseInt(br.readLine());
			arr[seat] = true;
		}
		
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			if(arr[i] || arr[i-1]) {
				dp[i] = dp[i-1];
				continue;
			}
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[N]);
	}

}
