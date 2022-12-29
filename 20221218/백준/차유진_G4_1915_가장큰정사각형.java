import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		int maxLen = 0;
		
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
			}
		}
		int[][] dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 1) {
					if(dp[i][j] == 0) {
						int cnt = 0;
						for(int k = j; k < M; k++) {
							if(arr[i][k] == 1) {
								cnt++;
							} else break;
						}
						int c = 1;
						for(int k = cnt-1; k >= 0; k--) {
							dp[i][j+k] = c++;
						}
					}
				} 
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(dp[i][j] > 0 && dp[i][j] > maxLen) {
					int len = dp[i][j];
					int loop = 1;
					while(true) {
						if(loop >= len || len <= maxLen) break;
						if(i+loop >= N) {
							len = loop;
							break;
						}
						if(dp[i+loop][j] < len) {
							len = dp[i+loop][j];
						}
						loop++;
					}
					if(len > maxLen) {
						maxLen = len;
					}
				}
			}
		}
		System.out.println(maxLen*maxLen);
	}

}
