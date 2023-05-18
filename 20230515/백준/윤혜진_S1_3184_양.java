import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] map;
	static boolean[][] v;
	static int S, W;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		v = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'o') S++;
				else if(map[i][j] == 'v') W++;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'o' && !v[i][j])
					bfs(i, j);
			}
		}
		
		System.out.println(S+" "+W);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		v[r][c] = true;
		
		int sheep = 1;
		int wolf = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<R && nc<C) || v[nr][nc] || map[nr][nc]=='#') continue;
				
				if(map[nr][nc] == 'o') sheep++;
				else if(map[nr][nc] == 'v') wolf++;
				
				q.add(new int[] {nr, nc});
				v[nr][nc] = true;
			}
		}
		
		if(sheep > wolf) W -= wolf;
		else S -= sheep;	
	}

}
