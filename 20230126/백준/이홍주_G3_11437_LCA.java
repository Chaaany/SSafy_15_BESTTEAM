import java.io.*;
import java.util.*;

public class BJ_11437_LCA {

	static int N, M;
	static ArrayList<ArrayList<Integer>> tree;
	static int[] depth, parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < N+1; i++) {
			tree.add(new ArrayList<Integer>());		
		}
		
		for (int i = 0; i < N-1; i++) {
			st =  new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			tree.get(x).add(y);
			tree.get(y).add(x);
		}
		
		depth = new int[N+1];
		parent = new int[N+1];
		
		// 정점들의 depth 구하기
		dfs(1,1);
		
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st =  new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			sb.append(LCA(x,y,depth[x], depth[y])+"\n");
		}
		System.out.print(sb.toString());
	}

	private static int LCA(int x, int y, int x_depth, int y_depth) {	
		// 둘의 depth를 동일하게
		if(x_depth>y_depth) {
			while(x_depth != y_depth) {
				x_depth--;
				x = parent[x];
			}
		}else if(x_depth<y_depth) {
			while(x_depth != y_depth) {
				y_depth--;
				y = parent[y];
			}
		}
		
		while(x!=y) {
			x = parent[x];
			y = parent[y];
		}
		
		return x;
	}

	private static void dfs(int from, int cnt) {
		depth[from] = cnt++;
		for(Integer idx: tree.get(from)) {
			if(depth[idx]==0) {
				dfs(idx,cnt);
				parent[idx] = from;
			}
		}
	}

}
