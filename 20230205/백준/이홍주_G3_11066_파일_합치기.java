import java.io.*;
import java.util.*;

public class BJ_11066_파일합치기 {

	static int[] file, sum;
	static int[][] dp;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			file = new int[N+1];
			sum = new int[N+1];
			dp = new int[N+1][N+1];
			
			st = new StringTokenizer(br.readLine());			
			for (int i = 1; i <= N; i++) {
				file[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1]+file[i];
			}

			// 간격
			for (int d = 1; d <= N; d++) {
				// 시작점
				for (int i = 1; i+d <= N; i++) {
					dp[i][i+d] = Integer.MAX_VALUE;
					
					// 중간 지점
					for (int k = i; k < i+d; k++) {
						dp[i][i+d] = Math.min(dp[i][i+d], dp[i][k]+dp[k+1][i+d]+sum[i+d]-sum[i-1]);
					}
				}
			}
			System.out.println(dp[1][N]);
		}
	}

}
