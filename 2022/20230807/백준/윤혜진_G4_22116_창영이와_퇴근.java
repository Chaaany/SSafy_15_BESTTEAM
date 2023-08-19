import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int max;
	
	public static class Node implements Comparable<Node>{
		int r;
		int c;
		int cost;
		
		public Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(max);
	}

	private static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		v = new boolean[N][N];
		pq.add(new Node(0,0,0));  // r, c, 바로 전 경사
		v[0][0] = true;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int cr = cur.r;
			int cc = cur.c;
			max = Math.max(max, cur.cost);
            v[cr][cc] = true;
            
			if(cr == N-1 && cc == N-1) {
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<N && nc<N) || v[nr][nc]) continue;
				
				int ncost = Math.abs(map[cr][cc]-map[nr][nc]);
				pq.add(new Node(nr, nc, ncost));
			}
		}
		
	}

}
