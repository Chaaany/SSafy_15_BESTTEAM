import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, K, R;
	static List<int[]> cows;
	static Set<String> set;
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		cows = new ArrayList<>();
		set = new HashSet<>();
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			set.add(x1+" "+y1+" "+x2+" "+y2);
			set.add(x2+" "+y2+" "+x1+" "+y1);
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 1;
			cows.add(new int[] {x,y});
		}
		
		int count = 0;
		for(int[] c: cows) {
			count += K - 1 -bfs(c[0], c[1]);
		}
		
		System.out.println(count/2);
	}

	private static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[N+1][N+1];
		q.add(new int[] {r, c});
		v[r][c] = true;
		
		int cowCount = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			loop:
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>0 && nc>0 && nr<=N && nc<=N) || v[nr][nc]) continue;
				
				if(set.contains(cr+" "+cc+" "+nr+" "+nc)) continue loop;
				
				if(map[nr][nc] == 1) cowCount++;
				q.add(new int[] {nr, nc});
				v[nr][nc] = true;
			}
		}
		
		return cowCount;		
	}

}
