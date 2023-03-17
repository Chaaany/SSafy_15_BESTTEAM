import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_17425_YakSooHap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] fx = new long[1000001]; // 해당 자연수의 약수합
		long[] dp = new long[1000001]; // 이 자연수 이하까지의 fx 합
		Arrays.fill(fx, 1);
		for (int i = 2; i < 1000001; i++) { // 2부터 나눠가면서
			for (int j = 1; i * j < 1000001; j++) { // 100만이 넘지 않을 때까지 곱하면서
				fx[i * j] += i; // 약수를 더해준다.
			}
		}
		for (int i = 1; i < dp.length; i++) {
			dp[i] += dp[i - 1] + fx[i]; // 약수의 누적합 구하기
		}

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N] + "\n");
		}
		System.out.println(sb);
	}
}
