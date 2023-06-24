import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int L, R, C, EL, ER, EC;
	static boolean success;
	static char[][][] map;
	static int[][][] time;
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static int[] dr = { 0, 0, 1, -1, 0, 0 };
	static int[] dc = { 1, -1, 0, 0, 0, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L==0 && R==0 && C==0) break;
			map = new char[L][R][C];
			
			int sl = 0;
			int sr = 0;
			int sc = 0;
			for (int h = 0; h < L; h++) {
				for (int i = 0; i < R; i++) {
					String line = br.readLine();
					for (int j = 0; j < C; j++) {
						map[h][i][j] = line.charAt(j);
						if(map[h][i][j] == 'S') {
							sl = h;
							sr = i;
							sc = j;
						}
					}
				}
				br.readLine();
			}
			
			bfs(sl, sr, sc);
			
			if(success) {
				sb.append("Escaped in "+time[EL][ER][EC]+" minute(s).\n");
			}
			else sb.append("Trapped!\n");
		}
		
		System.out.println(sb);
	}

	private static void bfs(int h, int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] v = new boolean[L][R][C];
		
		q.add(new int[] {h, r, c});
		v[h][r][c] = true;
		success = false;
		time = new int[L][R][C];
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int ch = cur[0];
			int cr = cur[1];
			int cc = cur[2];
			
			for (int d = 0; d < 6; d++) {
				int nh = ch + dh[d];
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nh>=0 && nr>=0 && nc>=0 && nh<L && nr<R && nc<C)
						|| map[nh][nr][nc] == '#' || v[nh][nr][nc]) continue;
				
				time[nh][nr][nc] = time[ch][cr][cc]+1;
				q.add(new int[] {nh, nr, nc});
				v[nh][nr][nc] = true;
				if(map[nh][nr][nc] == 'E') {
					success = true;
					EL = nh;
					ER = nr;
					EC = nc;
					return;
				}
			}
		}
		
	}

}
