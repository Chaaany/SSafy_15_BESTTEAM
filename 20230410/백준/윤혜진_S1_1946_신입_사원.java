import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static class Node implements Comparable<Node> {
		int report;
		int interview;
		
		public Node(int report, int interview) {
			this.report = report;
			this.interview = interview;
		}
		
		public int compareTo(Node o) {
			return this.report - o.report;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			int count = 0;
			int prev = Integer.MAX_VALUE;
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				if(cur.interview < prev) {
					count++;
					prev = cur.interview;
				}
			}
			
			sb.append(count+"\n");
		}
		
		System.out.println(sb);
	}

}
