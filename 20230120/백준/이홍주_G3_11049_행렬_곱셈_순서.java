import java.io.*;
import java.util.*;

public class BJ_11049_행렬곱셈순서 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 구간 사이의 곱셈 연산 횟수 최솟값
		long[][] dp = new long[N][N];
		
		//구간 크기
		for (int i = 1; i < N; i++) {
			// 시작점
			for (int j = 0; i+j < N; j++) {
				dp[j][i+j] = Integer.MAX_VALUE;
				// 구간 사이에 중간 지점 자르고 행렬 곱셈 계산
				for (int k = j; k < i+j; k++) {
          // j~구간 k + 구간 k+1~구간 마지막 열 + 두 행렬을 곱한 횟수(N*M*K)
					dp[j][i+j] = Math.min(dp[j][i+j], dp[j][k]+dp[k+1][i+j]+arr[j][0]*arr[k][1]*arr[i+j][1]);
				}
			}
		}
		// 시작~마지막까지 곱셈 연산 횟수 최솟값
		System.out.println(dp[0][N-1]);
	}

}
