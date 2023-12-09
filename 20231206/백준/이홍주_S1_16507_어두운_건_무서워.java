import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class BJ_16507_어두운건문서워 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R+1][C+1];
		long[][] dp = new long[R+1][C+1];
		
		for (int r = 1; r <= R; r++) {
			 st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				dp[r][c] = map[r][c] + dp[r-1][c] + dp[r][c-1] - dp[r-1][c-1];
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			sb.append((dp[r2][c2]-dp[r2][c1-1]-dp[r1-1][c2]+dp[r1-1][c1-1])/((r2-r1+1)*(c2-c1+1))+"\n");
		}
		
		
		System.out.print(sb.toString());
	}


}
