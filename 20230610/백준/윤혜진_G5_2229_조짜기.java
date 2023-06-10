import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N+1];
		int[] dp = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			int max = score[i];
			int min = score[i];
			dp[i] = dp[i-1];
			
			for (int j = i-1; j > 0; j--) {
				max = Math.max(max, score[j]);
				min = Math.min(min, score[j]);
				dp[i] = Math.max(dp[i], (max-min)+dp[j-1]);
			}
		}
		
		System.out.println(dp[N]);
	}

}
