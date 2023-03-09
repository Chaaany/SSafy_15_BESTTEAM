import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15843_MinimumEdit {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int[][] dp = new int[a.length() + 1][b.length() + 1];
		// dp[i][j] 는 a의 0~i까지를 b의 0~j까지의 문자열로 바꾸기 위해 필요한 최소 편집의 수
		//아래는 dp 초기 배열 채우기
		for (int i = 0; i < a.length() + 1; ++i) {
			dp[i][0] = i;
		}
		for (int i = 0; i < b.length() + 1; ++i) {
			dp[0][i] = i;
		}
		for (int i = 1; i < a.length() + 1; ++i) {
			for (int j = 1; j < b.length() + 1; ++j) {
				// 만약 a의 i번째 문자랑 b의 j번째 문자가 같으면 걔네는 편집 할 필요 없으므로 dp[i-1][j-1] 그대로 가져오기
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}
				// 둘이 다르다면 i-1을 j로, j-1을 i로, i-1을 j-1로 만드는 세 가지 경우의 수 중 최소값을 찾아서 거기에 편집 횟수 1 더하기
				else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
				}
			}
		}
		System.out.println(dp[a.length()][b.length()]);
	}

}
