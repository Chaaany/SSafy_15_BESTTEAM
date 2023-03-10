import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static class Node implements Comparable<Node> {
		int from;
		int to;
		int cost;
		
		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] isMan = new boolean[N+1];
		ArrayList<Node>[] arr = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			if(st.nextToken().equals("M"))
				isMan[i] = true;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			arr[from].add(new Node(from, to, cost));
			arr[to].add(new Node(to, from, cost));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] v = new boolean[N+1];		
		int sum = 0;
		int edge = 0;
		pq.add(new Node(0,1,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(v[cur.to]) continue;
			v[cur.to] = true;
		
			sum += cur.cost;
			edge++;
			
			for (int i = 0; i < arr[cur.to].size(); i++) {
				Node next = arr[cur.to].get(i);

				// 남학교 여학교 교차되어야 함
				if(isMan[next.to] != isMan[cur.to]) {
					pq.add(next);
				}
			}
		}
		
		if(edge == N) System.out.println(sum);
		else System.out.println(-1);
	}

}
