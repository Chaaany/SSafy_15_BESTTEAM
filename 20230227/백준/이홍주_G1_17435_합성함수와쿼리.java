import java.io.*;
import java.util.*;

public class BJ_17435_합성함수와쿼리 {

	static int M, Q;
	static int[][] dp;
	static final int log = 19; // log50만
	
	// 비트마스킹 + DP => 희소 배열 (LCA)
	// 처음 보는 유형..
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		M = Integer.parseInt(br.readLine());
		// 행은 2의 지수만큼 늘어남
		dp = new int[log+1][M+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			// 원본 배열
			dp[0][i] = Integer.parseInt(st.nextToken());
		}
		
		// 희소 배열 만들기
		for (int i = 1; i <= log; i++) {
			for (int j = 1; j <= M; j++) {
				// f8(x) => f4(f4(x)) 로 나타낼 수 있음
				dp[i][j] = dp[i-1][dp[i-1][j]];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Q = Integer.parseInt(br.readLine());
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i <= log; i++) {
				// ** 1의 자리 수 부터 n을 표현할 수 있는 숫자일 때 x를 갈아 끼워준다.
				// i는 2의 지수
				if((n & (1 << i)) > 0) x = dp[i][x];
			}
			
			sb.append(x+"\n");
		}
		System.out.print(sb.toString());
	}

}
