import java.io.*;
import java.util.PriorityQueue;
public class BJ_1509_팰린드롬분할 {


	static boolean[][] pelin;
	
	public static boolean check(int s,int e,String str) {
		if(str.charAt(s)==str.charAt(e)) {
			// 내부가 팰린드롬이면 팰린드롬이다
			if(Math.abs(s-e)<=1 || pelin[s+1][e-1]) {
				pelin[s][e] = true;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int N = str.length();
		
		// 최소 개수 저장
		int[] dp = new int[N];
		pelin = new boolean[N][N];
		dp[0] = 1;
		
		for (int i = 1; i < N; i++) {
			dp[i] = dp[i-1]+1;
			for (int j = 0; j <= i; j++) {
				// 팰린드롬인지 확인
				if(check(j, i, str)) {
					// 처음부터 팰린드롬이니 개수가 1이 최소
					if(j==0) dp[i] = 1;
					else dp[i] = Math.min(dp[i], dp[j-1]+1);
				}
			}
		}	
		System.out.println(dp[N-1]);
	}
}
