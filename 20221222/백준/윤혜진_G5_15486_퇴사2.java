import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		int max = 0;
		for (int i = 0; i < N+1; i++) {
			if(i==N) {
				max = Math.max(max, dp[i]);
				break;
			}
			
			int cost = map[i][1];
			int endDay = i + map[i][0];
			max = Math.max(max, dp[i]);
			
			if(endDay < N+1)
				dp[endDay] = Math.max(dp[endDay], max+cost);

		}
		
		System.out.println(max);		
		
	}

}
