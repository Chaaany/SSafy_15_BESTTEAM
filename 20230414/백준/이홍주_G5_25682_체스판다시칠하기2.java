import java.io.*;
import java.util.*;

public class BJ_25682_체스판다시칠하기2 {

	static int N,M,K, answer;
	static int[][] dp_white, dp_black;
	
	// 2차원 배열 누적합
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp_white = new int[N+1][M+1];
		dp_black = new int[N+1][M+1];
		
		answer = Integer.MAX_VALUE;
		
		// W로 시작하는 것, B로 시작하는 것 따로 check 
		for (int i = 1; i <= N; i++) {
			String str = br.readLine().trim();
			for (int j = 1; j <= M; j++) {
				char now = str.charAt(j-1);
				
				// 행+열이 짝이면 시작하는 색과 같아야 함
				// 색이 같으면 0, 달라서 색칠해야 하면 1
				if((i+j)%2 == 0 && now =='B' 
						|| (i+j)%2 == 1 && now =='W') {
					dp_white[i][j] = 1;
				}
				
				if((i+j)%2 == 0 && now =='W' 
						|| (i+j)%2 == 1 && now =='B') {
					dp_black[i][j] = 1;
				}
				
				// 누적합 1,1 ~ i,j까지의 1 개수의 누적합
				dp_white[i][j] += dp_white[i-1][j] + dp_white[i][j-1] - dp_white[i-1][j-1];
				dp_black[i][j] += dp_black[i-1][j] + dp_black[i][j-1] - dp_black[i-1][j-1];
				
				if(i>=K && j>=K) {
					// 두개의 누적합 중 최솟값을 계속 갱신
					int white = dp_white[i][j] - dp_white[i-K][j] - dp_white[i][j-K] + dp_white[i-K][j-K];
					int black = dp_black[i][j] - dp_black[i-K][j] - dp_black[i][j-K] + dp_black[i-K][j-K];
					answer = Math.min(answer, Math.min(white, black));
				}
			}
		}
		
		System.out.println(answer);
	}
	
}
