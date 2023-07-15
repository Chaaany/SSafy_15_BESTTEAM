import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static class Node implements Comparable<Node> {
		int to;
		long cost;
		
		public Node(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return (int)(this.cost - o.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] see = new int[N];  // 시야에 보이는지
		ArrayList<Node>[] edge = new ArrayList[N];  // 간선
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			see[i] = Integer.parseInt(st.nextToken());
			edge[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());
						
			edge[from].add(new Node(to, cost));
			edge[to].add(new Node(from, cost));
		}
		
		long[] distance = new long[N];
		Arrays.fill(distance, Long.MAX_VALUE);
		distance[0] = 0;
		boolean finish = false;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] v = new boolean[N];
		pq.add(new Node(0,0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.to == N-1) finish = true;
			
			if(v[cur.to]) continue;
			v[cur.to] = true;

			for (Node next : edge[cur.to]) {
				if(next.to != N-1 && see[next.to] == 1) continue;
				
				if(distance[next.to] > distance[cur.to] + next.cost) {
					distance[next.to] = distance[cur.to] + next.cost;
					pq.add(new Node(next.to, distance[next.to]));
				}
			}
		}
		
		System.out.println(finish?distance[N-1]:-1);
	}

}
