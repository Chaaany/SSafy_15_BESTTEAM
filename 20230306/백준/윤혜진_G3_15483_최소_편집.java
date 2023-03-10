import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();
		int[][] dp = new int[a.length()+1][b.length()+1];

		// 글자수만큼 초기화
		for (int i = 0; i < a.length()+1; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i < b.length()+1; i++) {
			dp[0][i] = i;
		}
		
		for (int i = 1; i < a.length()+1; i++) {
			for (int j = 1; j < b.length()+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],  dp[i][j-1])) +1;
				}
			}
		}
		
		System.out.println(dp[a.length()][b.length()]);
		
	}

}
