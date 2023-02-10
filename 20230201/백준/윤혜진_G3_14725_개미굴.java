import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static class Node implements Comparable<Node>{
		String name;
		int depth;
		PriorityQueue<Node> child;
		
		public Node(String name, int depth) {
			this.name = name;
			this.depth = depth;
			child = new PriorityQueue<Node>();
		}

		@Override
		public int compareTo(Node o) {
			return this.name.compareTo(o.name);
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> list = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			
			Node parentNode = new Node("", 0);
			
			loop:
			for (int j = 0; j < K; j++) {
				String a = st.nextToken();
				
				for (Node node : list) {
					if(node.name.equals(a) && node.depth == j) {
						parentNode = node;
						continue loop;
					}
				}
				
				// 부모가 없을 때
				if(parentNode.name.equals("")) {
					Node childNode = new Node(a, j);
					parentNode.child.add(childNode);
					list.add(childNode);
					parentNode = childNode;
				}
				// 부모가 있을 때
				else {
					Node childNode = new Node(a, j);
					
					for (Node node : parentNode.child) {
						if(node.name.equals(a) && node.depth == j) {
							parentNode = node;
							continue loop;
						}
					}
					parentNode.child.add(childNode);
					parentNode = childNode;
				}
				
			}
			
		}
		
		dfs(list);
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}

	private static void dfs(PriorityQueue<Node> node) {
		while(!node.isEmpty()) {
			Node cur = node.poll();
			for (int i = 0; i < cur.depth; i++) {
				sb.append("--");
			}
			sb.append(cur.name+"\n");
			if(cur.child.size() > 0)
				dfs(cur.child);
		}
	}

}
