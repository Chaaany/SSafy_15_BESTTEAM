import java.io.*;
import java.util.*;

public class BJ_11722_가장긴감소하는부분수열 {

	static int N, answer;
	static int[] dp, arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		arr = new int[N+1];
		
		answer = 1;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if(arr[i] < arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1); 
			}
			answer = Math.max(dp[i], answer);
		}
		System.out.println(answer);
		
	}
	
}
