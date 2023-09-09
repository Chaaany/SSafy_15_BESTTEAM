import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class BJ_11060_점프점프 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] =  Integer.parseInt(st.nextToken());
			dp[i] = Integer.MAX_VALUE;
		}
		
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			if(dp[i]==Integer.MAX_VALUE) continue;
			for (int j = i; j <= i+arr[i]; j++) {
				if(j>=N) break;
				dp[j] = Math.min(dp[j], dp[i]+1);
			}
		}
		
		System.out.println(dp[N-1]==Integer.MAX_VALUE?-1:dp[N-1]);
	}


}
