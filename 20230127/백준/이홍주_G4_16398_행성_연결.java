import java.io.*;
import java.util.*;

public class BJ_16398_행성연결 {

	static int N;
	static long answer;
	static int[][] map;
	public static class Node implements Comparable<Node>{	
		int idx;
		int cost;
		public Node(int idx, int cost) {		
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st  = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		PriorityQueue<Node> pq = new  PriorityQueue<>();
		boolean[] v = new boolean[N];
		pq.add(new Node(0, map[0][0]));
		
		// MST - Prim알고리즘
		while(!pq.isEmpty()) {
			// 정점 중심으로 최소 간선 선택
			Node node = pq.poll();
			// MST에 포함되었으면 pass
			if(v[node.idx]) continue;
			
			answer += node.cost;
			v[node.idx] = true;	
			for (int e = 0; e < N; e++) {
				if(!v[e] && e!=node.idx) pq.add(new Node(e, map[node.idx][e]));
			}
		}		
		System.out.println(answer);
	}

}
