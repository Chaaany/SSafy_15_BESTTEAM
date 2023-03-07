import java.io.*;

public class BJ_15483_최소편집 {

	// LCS DP 문제와 유사
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String start = br.readLine().trim();
		String end = br.readLine().trim();
		
		// ~i 에서 ~j로 변환하는 최소편집거리
		int[][] dp = new int[start.length()+1][end.length()+1];
		
		// 공백과 비교하는건 그전의 연산에서 +1해줌
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = dp[i-1][0]+1;
		}
		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = dp[0][i-1]+1;
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(start.charAt(i-1)==end.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
				// i-1, j-1은 교체 / i-1,j 삭제? / i, j-1 삽입?
				else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
			}
		}
		System.out.println(dp[start.length()][end.length()]);
	}

	
}
