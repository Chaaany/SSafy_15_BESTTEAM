import java.io.*;
import java.util.*;

public class BJ_16112_5차전직 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n+1];
		long[] dp = new long[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i-1] + arr[i];
		}
		
		long answer = 0;
		
		for (int i = 1; i <= k; i++) {
			answer += dp[n] - dp[i];
		}
		
		System.out.println(answer);
	}

}
