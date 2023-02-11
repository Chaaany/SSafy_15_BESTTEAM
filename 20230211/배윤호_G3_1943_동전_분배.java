import java.io.*;
import java.util.*;

public class BJ_1943_CoinAllocating {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 3; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] value = new int[N];
			int[] many = new int[N];
			int total = 0;
			boolean[] dp = new boolean[100001];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				value[i] = Integer.parseInt(st.nextToken());
				many[i] = Integer.parseInt(st.nextToken());
				for (int j = 1; j < many[i] + 1; j++) {
					dp[value[i] * j] = true; // 주어지는 동전들로 만들 수 있는 값 미리 true로 만들어 놓기
				}
				total += value[i] * many[i]; // 전체 금액 구하기
			}
			if (total % 2 == 1) { // 만약 전체 값이 2로 나누어 떨어지지 않으면 반으로 못나누니까 0
				System.out.println(0);
				continue;
			}
			if (dp[total / 2]) { // 이미 전체 금액의 절반을 만들 수 있다면 1 하고 여기까지
				System.out.println(1);
				continue;
			}
			for (int i = 0; i < N; i++) { // 모든 동전에 대해
				int v = value[i];
				int m = many[i];
				for (int j = 0; j < total / 2; j++) { // 0부터 토탈/2까지 여기 넘어가면 굳이 할 필요 없음
					if (j - v >= 1) { // 현재 동전 뺀 값이 1보다 큰 경우부터
						if (dp[j - v]) { // 그 값이 true면(만들 수 있으면)
							for (int k = 0; k < m; k++) { // 동전 숫자 쓰면서 만들 수 있는 값을 다 true로 만듦
								if (j - v + v * k > total / 2) // 근데 이것도 total/2 넘어가면 할 필요 없으니까 멈춤
									break;
								dp[j - v + v * k] = true;
							}

						}
					}
				}
			}
			if (dp[total / 2]) { // 만약 전체 값 나누기 2 를 만들 수 있으면
				System.out.println(1); // 1
			} else { // 아니면
				System.out.println(0); // 0
			}

		}
	}

}
