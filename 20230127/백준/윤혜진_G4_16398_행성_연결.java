import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	
	public static class Node implements Comparable<Node> {
		int s;
		int e;
		int c;
		
		public Node(int s, int e, int c) {
			this.s = s;
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return this.c - o.c;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		parent = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int c = Integer.parseInt(st.nextToken());
				
				if(c == 0) continue;
				pq.add(new Node(i, j, c));
			}
		}
			
		// 부모노드 자기 자신으로 초기화
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		long sum = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
						
			if(find(cur.s) == find(cur.e)) continue;
			else {
				union(cur.s, cur.e);
				sum += cur.c;
			}
		}
		
		System.out.println(sum);

	}
	
	public static int find(int x) {
		if(x == parent[x])
			return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		// 부모노드 찾기
		x = find(x);
		y = find(y);
		
		if(x != y) {
			if(x < y) parent[y] = x;
			else parent[x] = y;
		}
	}

}
