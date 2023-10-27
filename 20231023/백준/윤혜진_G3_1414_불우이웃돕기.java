import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	
	static int N;
	static int costs;
	static boolean[] v;
	static List<Node>[] list;

	public static class Node implements Comparable<Node> {
		int idx;
		int cost;
		
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		v = new boolean[N+1];
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= N; j++) {
				char c = line.charAt(j-1);
				if(c != '0') {
					if(c-'a' >= 0) {
						list[i].add(new Node(j, c-'a'+1));
						list[j].add(new Node(i, c-'a'+1));
						costs += c-'a'+1;
					}
					else {
						list[i].add(new Node(j, c-'A'+1+26));
						list[j].add(new Node(i, c-'A'+1+26));
						costs += c-'A'+1+26;
					}
				}
			}
		}
		
		prim();
		
		boolean check = true;
		for (int i = 1; i <= N; i++) {
			if(!v[i]) {
				check = false;;
				break;
			}
		}
		
		System.out.println(check?costs:-1);
	}

	private static void prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(v[cur.idx]) continue;
			v[cur.idx] = true;
			costs -= cur.cost;
			
			for(Node next: list[cur.idx]) {
				if(!v[next.idx]) {
					pq.add(next);
				}
			}
		}
	}

}
