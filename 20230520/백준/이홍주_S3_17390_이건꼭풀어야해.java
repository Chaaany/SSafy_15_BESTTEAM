import java.io.*;
import java.util.*;

public class BJ_17390_이건꼭풀어야해 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N+1];
		int[] dp = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i-1] + A[i];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			sb.append(dp[e]-dp[s-1]+"\n");
		}
		
		System.out.print(sb.toString());
	}
	
}
