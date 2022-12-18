import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		
		int[][] dp = new int[N][M];
		int answer = 0;
		
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < M; j++) {
				if(i==0 || j==0) dp[i][j] = map[i][j];
				else if(map[i][j] == 0) dp[i][j]=0;
				else {
					dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]))+1;
				}
				answer = Math.max(answer, dp[i][j]);
			}
		}
		System.out.println(answer*answer);
	}
}
