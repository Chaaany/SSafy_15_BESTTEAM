import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사냥터 수
		int T = Integer.parseInt(st.nextToken()); // 주어진 시간
		int[] c = new int[N+1]; // 입장에 필요한 경험치
		int[] e = new int[N+1]; // 1분당 얻는 경험치
		int[][] matrix = new int[T+1][T+1]; // 사냥터간 이동 시간 배열
		int[][] dp = new int[T+1][N+1]; //dp 배열
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			c[i] = Integer.parseInt(st.nextToken());
			e[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(c));
//		System.out.println(Arrays.toString(e));
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
//				System.out.println(matrix[i][j]+" ");
			}
//			System.out.println();
		}

		for (int i = 0; i < T; i++) {
			for (int j = 1; j <= N; j++) {
				// 사냥터를 옮기지 않고 계속 사냥하는 경우
				if (dp[i][j] >= c[j])
					dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + e[j]);
				for (int k = 1; k <= N; k++) {
					if (i + matrix[j][k] <= T && dp[i][j] >= c[k]) {
						// k번 사냥터로 옮기기로 한 경우
						dp[i + matrix[j][k]][k] = Math.max(dp[i + matrix[j][k]][k], dp[i][j]);
					}
				}
			}
		}
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			answer = Math.max(answer, dp[T][i]);
		}
		System.out.println(answer);

	}

}
