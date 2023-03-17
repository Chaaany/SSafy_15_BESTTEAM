import java.io.*;
import java.util.*;

public class BJ_13913_숨바꼭질4 {

	static int N,K;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		if(N>=K) {
			sb.append(N-K+"\n");
			for (int i = N; i >= K; i--) {
				sb.append(i+" ");
			}
		}else {
			// 최소갯수, 그전 idx
			dp = new int[2][K*2];
			
			for (int i = 0; i < K*2; i++) {
				// 뒤로가는것은 +1씩 해주면 된다
				if(i<=N) {
					dp[0][i] = N-i;
					dp[1][i] = i+1;
					if(i==N) dp[1][i] = i;
				}else {
					// 짝수면은 X2해서 온 위치일 수도있으니 최솟값 비교
					if(i%2==0) {
						if(dp[0][i/2] > dp[0][i-1] ) {
							dp[0][i] = dp[0][i-1]+1;
							dp[1][i] = i-1;
						}else {
							dp[0][i] = dp[0][i/2]+1;
							dp[1][i] = i/2;
						}
						
					}else {
						// 홀수면은 그 전에서 온 경우의 수밖에 없다
						dp[0][i] = dp[0][i-1] + 1;
						dp[1][i] = i-1;
					}
					
					// 바로 전 위치 최솟값 갱신
					if(i>0 && dp[0][i]+1 < dp[0][i-1]) {
						int idx = i;
						while(idx>0) {
							dp[0][idx-1] = dp[0][idx]+1;
							dp[1][idx-1] = idx;
							idx--;
							if(idx<=0 || dp[0][idx]+1 >= dp[0][idx-1]) break;
						}
					}
				}
			}
			// 최소값 출력
			sb.append(dp[0][K]+"\n");
			// dfs로 경로 탐색
			sb.append(N+" ");
			dfs(K, sb);
			
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
	private static void dfs(int idx, StringBuilder sb) {
		if(idx==N) return;
		dfs(dp[1][idx], sb);
		sb.append(idx+" ");
	}
	
}
