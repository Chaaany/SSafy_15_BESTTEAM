import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6593_SangBumBuilding {
	static int sl;
	static int sr;
	static int sc;
	static int el;
	static int er;
	static int ec;
	static int[] dl = { 1, -1 };
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if (L == 0) {
				break;
			}
			char[][][] map = new char[L][R][C];
			boolean[][][] v = new boolean[L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String s = br.readLine();
					for (int k = 0; k < C; k++) {
						map[i][j][k] = s.charAt(k);
						if (s.charAt(k) == 'S') {
							sl = i;
							sr = j;
							sc = k;
						} else if (s.charAt(k) == 'E') {
							el = i;
							er = j;
							ec = k;
						}
					}
				}
				br.readLine();
			}

			Queue<int[]> que = new LinkedList<>();
			que.add(new int[] { sl, sr, sc, 0 });
			v[sl][sr][sc] = true;
			boolean cango = false;
			int minTime = 0;
			go: while (!que.isEmpty()) {
				int[] cur = que.poll();
				int cl = cur[0];
				int cr = cur[1];
				int cc = cur[2];
				int cs = cur[3];
				for (int d = 0; d < 2; d++) {
					int nl = cl + dl[d];
					if (nl >= 0 && nl < L && map[nl][cr][cc] != '#' && !v[nl][cr][cc]) {
						v[nl][cr][cc] = true;
						que.add(new int[] { nl, cr, cc, cs + 1 });
						if (nl == el && cr == er && cc == ec) {
							cango = true;
							minTime = cs + 1;
							break go;
						}
					}
				}
				for (int d = 0; d < 4; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[cl][nr][nc] != '#' && !v[cl][nr][nc]) {
						v[cl][nr][nc] = true;
						que.add(new int[] { cl, nr, nc, cs + 1 });
						if (cl == el && nr == er && nc == ec) {
							cango = true;
							minTime = cs + 1;
							break go;
						}
					}
				}
			}
			if (cango) {
				sb.append("Escaped in " + minTime + " minute(s).\n");
			} else {
				sb.append("Trapped!\n");
			}
		}
		System.out.println(sb);
	}

}
