import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17435_CompositionFunctionAndQuery {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int[][] dp = new int[19][m + 1]; 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < m + 1; i++) {
			dp[0][i] = Integer.parseInt(st.nextToken()); 
		}
		//dp 배열 채우기
		for (int i = 1; i < 19; i++) {
			for (int j = 1; j < m + 1; j++) {
				dp[i][j] = dp[i - 1][dp[i - 1][j]];
			}
		}

		StringBuilder sb = new StringBuilder();

		int Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			for (int j = 18; j >= 0; j--) {
				int cur = (1 << j);
				if (n >= cur) {
					x = dp[j][x];
					n -= cur;
					if (n == 0)
						break;
				}
			}
			sb.append(x + "\n");
		}
		System.out.println(sb);

	}
	//솔직히 어려워서 이해 안됨 ... 홍주의 설명을 기대한다

}
