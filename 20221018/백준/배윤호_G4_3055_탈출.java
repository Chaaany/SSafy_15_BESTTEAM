import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int sr, sc;
	static int er, ec;
	static int R, C;
	static char[][] map;
	static boolean[][] gosmV;
	static boolean[][] waterV;
	static int count = 0;
	static boolean canGo = false;
	static Queue<int[]> water;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		gosmV = new boolean[R][C];
		waterV = new boolean[R][C];
		map = new char[R][C];
		water = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				if (s.charAt(j) == 'S') {
					sr = i;
					sc = j;
				}
				if (s.charAt(j) == 'D') {
					er = i;
					ec = j;
				}
				if (s.charAt(j) == '*') {
					water.add(new int[] { i, j });
					waterV[i][j] = true;
				}
				map[i][j] = s.charAt(j);
			}
		}
		bfs();
		if (canGo) {
			System.out.println(count);
		} else {
			System.out.println("KAKTUS");
		}
	}

	private static void bfs() {
		Queue<int[]> gosm = new LinkedList<>();
		gosm.add(new int[] { sr, sc });
		gosmV[sr][sc] = true;
		while (!gosm.isEmpty()) {
			// 물 먼저
			count++;
			int wSize = water.size();
			for (int i = 0; i < wSize; i++) {
				int[] cWater = water.poll();
				int cr = cWater[0];
				int cc = cWater[1];
				for (int d = 0; d < 4; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] == '.' && map[nr][nc] != 'D') {
						water.add(new int[] { nr, nc });
						map[nr][nc] = '*';
						waterV[nr][nc] = true;
					}
				}
			}
			// 고슴도치 이동
			int gSize = gosm.size();
			for (int i = 0; i < gSize; i++) {
				int[] cGosm = gosm.poll();
				int cr = cGosm[0];
				int cc = cGosm[1];
				for (int d = 0; d < 4; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					if (nr == er && nc == ec) {
						canGo = true;
						return;
					}
					if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] == '.') {
						gosm.add(new int[] { nr, nc });
						map[nr][nc] = 'S';
						gosmV[nr][nc] = true;
					}
				}
			}

		}

	}

}
