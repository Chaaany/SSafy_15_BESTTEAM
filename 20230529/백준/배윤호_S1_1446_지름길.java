import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1446_ShortCut {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] dp = new int[D + 1];
		PriorityQueue<shortcut> pq = new PriorityQueue<>();
		for (int i = 0; i < D; i++) {
			dp[i] = i;
		}

		for (int i = 0; i < D + 1; i++) {
			dp[i] = i;
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (e > D)
				continue;
			if (e - s <= d)
				continue;
			pq.add(new shortcut(s, e, d));
		}
		for (int i = 1; i < D + 1; i++) {
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);

			while (!pq.isEmpty() && pq.peek().e == i) {
				shortcut cur = pq.poll();
				dp[cur.e] = Math.min(dp[cur.e], dp[cur.s] + cur.d);
			}
		}

		System.out.println(dp[D]);
	}

	public static class shortcut implements Comparable<shortcut> {
		int s;
		int e;
		int d;

		public shortcut(int s, int e, int d) {
			this.s = s;
			this.e = e;
			this.d = d;
		}

		public int compareTo(shortcut s) {
			if (s.e != this.e) {
				return this.e - s.e;
			}
			if (s.s != this.s) {
				return this.s - s.s;
			}
			return this.d - s.d;
		}

	}

}
