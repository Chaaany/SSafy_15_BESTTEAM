import java.io.*;
import java.util.*;

public class BJ_1981_배열에서이동 {
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int N, max, min;
	static int[][] map;
	public static class Node{		
		int r;
		int c;
				
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}		
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		
		int answer = Integer.MAX_VALUE;
		int left = min;
		int right = min;
		
		while(left<=max && right<=max) {
			if(bfs(left,right)) {
				answer = Math.min(answer, right-left);
				left++;
			}else {
				right++;
			}
		}
		
		System.out.println(answer);			
	}
	private static boolean bfs(int left, int right) {
		if(map[0][0] < left || map[0][0]>right) return false;
		Queue<Node> pq = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		
		pq.add(new Node(0,0));
		v[0][0] = true;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.r==N-1 && now.c==N-1) {
				return true;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				if(cango(nr,nc) && !v[nr][nc]) {
					if(map[nr][nc] < left || map[nr][nc] > right) continue;
					pq.add(new Node(nr, nc));					
					v[nr][nc] = true;
				}
			}			
		}
		return false;
	}
	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}

}
