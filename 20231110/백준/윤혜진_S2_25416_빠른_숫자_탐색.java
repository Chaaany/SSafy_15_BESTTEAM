import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int er, ec;
	static int[][] map, cnt;
	static boolean[][] v;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[5][5];
		cnt = new int[5][5];
		v = new boolean[5][5];
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					er = i;
					ec = j;
				}
				cnt[i][j] = INF;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		bfs(sr, sc);
		
		System.out.println(cnt[er][ec]>=INF?-1:cnt[er][ec]);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		v[r][c] = true;
		cnt[r][c] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<5 && nc<5) || v[nr][nc] || map[nr][nc] == -1)
					continue;
				
				v[nr][nc] = true;
				q.add(new int[] {nr, nc});
				cnt[nr][nc] = Math.min(cnt[nr][nc], cnt[cr][cc]+1); 
			}
		}
	}

}
