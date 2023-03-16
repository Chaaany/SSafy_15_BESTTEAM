import java.io.*;

public class BJ_17425_약수의합 {

	static final int MAX = 1000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[] dp = new long[MAX+1];
		long[] sum = new long[MAX+1];
		
		for (int i = 1; i <= MAX; i++) {
			for (int j = 1; j <= MAX/i; j++) {
				if(i*j > MAX) break;
				dp[i*j] += i;
			}
			sum[i] = dp[i]+sum[i-1];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
		
			sb.append(sum[N]+"\n");
		}
		System.out.print(sb.toString());
	}

}
