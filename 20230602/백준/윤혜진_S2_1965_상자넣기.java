import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] box = new int[n+1];
		int[] dp = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		Arrays.fill(dp, 1);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if(box[j] < box[i])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
	}

}
