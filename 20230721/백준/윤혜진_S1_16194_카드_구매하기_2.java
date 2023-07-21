import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] price = new int[N+1];
		int[] dp = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = price[1];
		for (int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= i; j++) {
				min = Math.min(dp[i-j]+price[j], min);
			}
			dp[i] = min;
		}
		
		System.out.println(dp[N]);
	}

}
