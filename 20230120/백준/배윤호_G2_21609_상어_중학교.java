import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_21609_SharkMiddleSchool {
	static int[][] map;
	static int N, M;
	static int score = 0;
	static boolean[][] v;
	static boolean check = true;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int maxr, maxc, maxBlock, maxRainbow;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (check) {
			auto();
		}

		System.out.println(score);

	}

	private static void auto() {
		// find block
		maxr = -1;
		maxc = -1;
		maxBlock = 0;
		maxRainbow = 0;
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i][j] == true || map[i][j] == 0 || map[i][j] == -1 || map[i][j] == -2) // -2는 블록 제거 후 빈 공간
					continue;
				bfs(i, j);
			}
		}
		// 지울 블록이 없으면 리턴
		if (maxr == -1 && maxc == -1) {
			check = false;
			return;
		}
		// delete block
		delete();
		// gravity block
		gravity();
		// turnReverseClock block
		turnReverseClock();
		// gravity block
		gravity();
	}

	private static void turnReverseClock() {
		int[][] turnMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				turnMap[i][j] = map[j][N - 1 - i];
			}
		}
		map = turnMap;
	}

	private static void gravity() {
		for (int i = N - 2; i >= 0; i--) {
			for (int j = N - 1; j >= 0; j--) {
				if (map[i][j] == -2 || map[i][j] == -1)
					continue;
				int num = map[i][j];
				int mr = i;
				while (true) {
					if (mr + 1 >= N || map[mr + 1][j] != -2) {
						map[i][j] = -2;
						map[mr][j] = num;
						break;
					}
					mr++;
				}
			}
		}

	}

	private static void delete() {
		int num = map[maxr][maxc];
		map[maxr][maxc] = -2;
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { maxr, maxc });
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if ((nr >= 0 && nr < N && nc >= 0 && nc < N) && (map[nr][nc] == 0 || map[nr][nc] == num)) {
					que.add(new int[] { nr, nc });
					map[nr][nc] = -2;
				}
			}
		}
		score += maxBlock * maxBlock;
	}

	private static void bfs(int r, int c) {
		int num = map[r][c];
		int block = 1;
		int rainbow = 0;
		boolean[][] v2 = new boolean[N][N];
		v2[r][c] = true;
		v[r][c] = true;
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { r, c });
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (map[nr][nc] == num && v2[nr][nc] == false) {
						v2[nr][nc] = true;
						v[nr][nc] = true;
						que.add(new int[] { nr, nc });
						block++;
					} else if (map[nr][nc] == 0 && v2[nr][nc] == false) {
						v2[nr][nc] = true;
						que.add(new int[] { nr, nc });
						block++;
						rainbow++;
					}
				}
			}
		}
		// 블록이 1개(자기자신)면 그룹이 아니므로
		if (block == 1) {
			return;
		}
		if (block > maxBlock) {
			maxr = r;
			maxc = c;
			maxBlock = block;
			maxRainbow = rainbow;
		} else if (block == maxBlock) {
			if (rainbow >= maxRainbow) {
				maxr = r;
				maxc = c;
				maxBlock = block;
				maxRainbow = rainbow;
			}
		}
	}

}
