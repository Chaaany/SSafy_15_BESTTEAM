import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static class Node implements Comparable<Node> {
		int start;
		int end;
		int distance;
		
		public Node(int start, int end, int distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
		public int compareTo(Node o) {
			if(o.end != this.end)
				return this.end - o.end;
			if(o.start != this.start)
				return this.start - o.start;
			return this.distance - o.distance;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			if(e > D || d >= e-s) continue;
			pq.add(new Node(s, e, d));
		}
		
		int[] dp = new int[D+1];
		for (int i = 0; i < D+1; i++) {
			dp[i] = i;
		}
		
		for (int i = 1; i < D+1; i++) {
			dp[i] = Math.min(dp[i], dp[i-1]+1);
			
			while (!pq.isEmpty() && pq.peek().end == i) {
				Node cur = pq.poll();
				dp[cur.end] = Math.min(dp[cur.end], dp[cur.start] + cur.distance);
			}
		}

		System.out.println(dp[D]);
	}

}
