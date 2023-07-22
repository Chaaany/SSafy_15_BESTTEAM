import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] dp = new int[41];
		dp[1] = 1;
		dp[2] = 2;
		int before = 0;
		int ans = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < M; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		for (int i = 3; i < 41; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		while (!pq.isEmpty()) {
			int after = pq.poll();
			if (after - before == 1) {
				before = after;
				continue;
			}
			ans *= dp[after - before - 1];
			before = after;
		}
		if (N != before) {
			ans *= dp[N - before];
		}
		System.out.println(ans);
	}

}
