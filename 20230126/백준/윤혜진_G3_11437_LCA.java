import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parent, depth;
	static ArrayList<Integer>[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		depth = new int[N+1];
		tree = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		
		// parent,depth 정보 갱신
		bfs();
		
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int lca = LCA(a,b);
			sb.append(lca+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static int LCA(int a, int b) {
		// depth를 같게 만들기, 더 깊은 것을 위로 올림
		if(depth[a] > depth[b]) {
			while(depth[a] != depth[b]) {
				a = parent[a];
			}
		}
		else {
			while(depth[a] != depth[b]) {
				b = parent[b];
			}
		}
		
		// 부모노드가 같을 때까지 올라감
		while(a != b) {
			a = parent[a];
			b = parent[b];
		}
		
		return a;
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
        parent[1] = 1;
		q.add(1);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int node: tree[cur]) {
				if(parent[node] == 0) {
					q.add(node);
					parent[node] = cur;
					depth[node] = depth[cur]+1;
				}
			}
		}
		
	}

}
