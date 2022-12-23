import java.io.*;
import java.util.*;

public class BJ_15486_퇴사2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][2];
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(max, dp[i]);
			int k = i+arr[i][0]-1;
			if(k <= N) {
				dp[k] = Math.max(dp[k], dp[i-1]+arr[i][1]);
			}
			max = Math.max(max, dp[i]);
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(max);
	}

}
