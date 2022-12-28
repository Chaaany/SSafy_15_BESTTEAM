import java.io.*;
import java.util.*;

public class BJ_12869_뮤탈리스크 {
	
	static int N;
	// 방문배열
	static int[][][] dp;
	
	// dfs + DP
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] arr = new int[3];
		dp = new int[61][61][61];
		for (int i = 0; i < 61; i++) {
			for (int j = 0; j < 61; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = dfs(arr[0], arr[1], arr[2]);
		System.out.println(answer);
	}
	
	private static int dfs(int a, int b, int c) {
		
		// 음수 계산 안하도록
		if(a<0) return dfs(0,b,c);
		if(b<0) return dfs(a,0,c);
		if(c<0) return dfs(a,b,0);
		
		// 더이상 공격할 필요 없음 
		if(a==0 && b==0 && c==0) return 0;
		
		// 이미 한번 방문 했으면 바로 리턴
		if(dp[a][b][c]!=-1) return dp[a][b][c];
		
		dp[a][b][c] = Integer.MAX_VALUE;
		
		dp[a][b][c] = Math.min(dp[a][b][c], dfs(a-9,b-3,c-1)+1);
		dp[a][b][c] = Math.min(dp[a][b][c], dfs(a-9,b-1,c-3)+1);
		dp[a][b][c] = Math.min(dp[a][b][c], dfs(a-3,b-9,c-1)+1);
		dp[a][b][c] = Math.min(dp[a][b][c], dfs(a-3,b-1,c-9)+1);
		dp[a][b][c] = Math.min(dp[a][b][c], dfs(a-1,b-3,c-9)+1);
		dp[a][b][c] = Math.min(dp[a][b][c], dfs(a-1,b-9,c-3)+1);
		
		return dp[a][b][c];
	}

}
