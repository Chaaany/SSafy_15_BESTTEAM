import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_23289_OnPoongGiHi {
	static int R, C, K;
	static int choco = 0;
	static boolean can = false;
	static Queue<On> ons = new LinkedList<>();
	static Queue<int[]> josa = new LinkedList<int[]>();
	static int[][] map;
	static boolean[][][] wall; // r,c,d r,c의 d방향에 벽이 있으면 true d가 0이면 상 1이면 우 2면 하 3이면 좌

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		wall = new boolean[R][C][4];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int temp = Integer.parseInt(st.nextToken());
				switch (temp) {
				case 0:
					break;
				case 5:
					josa.add(new int[] { i, j });
					break;
				default:
					ons.add(new On(i, j, temp));
					break;
				}
			}
		}
		int W = Integer.parseInt(br.readLine());
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			if (t == 0) {
				wall[r - 2][c - 1][2] = true;
				wall[r - 1][c - 1][0] = true;
			} else {
				wall[r - 1][c - 1][1] = true;
				wall[r - 1][c][3] = true;
			}
		}
		while (true) {
			find();
			if (can)
				break;
			if (choco > 100)
				break;
		}
		System.out.println(choco);
	}

	private static void find() {
		wind();
		control();
		outMinus();
		choco++;
		check();
	}
  // 온풍기 작동하는 함수
	private static void wind() {
		int size = ons.size();
		for (int i = 0; i < size; i++) {
			Queue<int[]> que = new LinkedList<int[]>();
			boolean[][] v = new boolean[R][C];
			On cur = ons.poll();
			ons.add(cur);
			int d = cur.d;
			int r = 0;
			int c = 0;
			switch (d) {
			// 우 온풍기
			case 1:
				r = cur.r;
				c = cur.c + 1;
				map[r][c] += 5;
				que.add(new int[] { r, c });
				v[r][c] = true;
				int hot1 = 4;
				while (hot1 > 0) {
					int size2 = que.size();
					for (int j = 0; j < size2; j++) {
						int[] cur2 = que.poll();
						int cr = cur2[0];
						int cc = cur2[1];

						int nr1 = cr - 1;
						int nc1 = cc + 1;
						if (nr1 >= 0 && nr1 < R && nc1 >= 0 && nc1 < C && !v[nr1][nc1] && !wall[nr1][nc1][3]
								&& !wall[nr1][nc1 - 1][2]) {
							que.add(new int[] { nr1, nc1 });
							v[nr1][nc1] = true;
							map[nr1][nc1] += hot1;
						}
						int nr2 = cr;
						int nc2 = cc + 1;
						if (nr2 >= 0 && nr2 < R && nc2 >= 0 && nc2 < C && !v[nr2][nc2] && !wall[nr2][nc2][3]) {
							que.add(new int[] { nr2, nc2 });
							v[nr2][nc2] = true;
							map[nr2][nc2] += hot1;
						}
						int nr3 = cr + 1;
						int nc3 = cc + 1;
						if (nr3 >= 0 && nr3 < R && nc3 >= 0 && nc3 < C && !v[nr3][nc3] && !wall[nr3][nc3][3]
								&& !wall[nr3][nc3 - 1][0]) {
							que.add(new int[] { nr3, nc3 });
							v[nr3][nc3] = true;
							map[nr3][nc3] += hot1;
						}
					}
					hot1--;
				}
				break;
			// 좌 온풍기
			case 2:
				r = cur.r;
				c = cur.c - 1;
				map[r][c] += 5;
				que.add(new int[] { r, c });
				v[r][c] = true;
				int hot2 = 4;
				while (hot2 > 0) {
					int size2 = que.size();
					for (int j = 0; j < size2; j++) {
						int[] cur2 = que.poll();
						int cr = cur2[0];
						int cc = cur2[1];

						int nr1 = cr - 1;
						int nc1 = cc - 1;
						if (nr1 >= 0 && nr1 < R && nc1 >= 0 && nc1 < C && !v[nr1][nc1] && !wall[nr1][nc1][1]
								&& !wall[nr1][nc1 + 1][2]) {
							que.add(new int[] { nr1, nc1 });
							v[nr1][nc1] = true;
							map[nr1][nc1] += hot2;
						}
						int nr2 = cr;
						int nc2 = cc - 1;
						if (nr2 >= 0 && nr2 < R && nc2 >= 0 && nc2 < C && !v[nr2][nc2] && !wall[nr2][nc2][1]) {
							que.add(new int[] { nr2, nc2 });
							v[nr2][nc2] = true;
							map[nr2][nc2] += hot2;
						}
						int nr3 = cr + 1;
						int nc3 = cc - 1;
						if (nr3 >= 0 && nr3 < R && nc3 >= 0 && nc3 < C && !v[nr3][nc3] && !wall[nr3][nc3][1]
								&& !wall[nr3][nc3 + 1][0]) {
							que.add(new int[] { nr3, nc3 });
							v[nr3][nc3] = true;
							map[nr3][nc3] += hot2;
						}
					}
					hot2--;
				}
				break;
			// 상 온풍기
			case 3:
				r = cur.r - 1;
				c = cur.c;
				map[r][c] += 5;
				que.add(new int[] { r, c });
				v[r][c] = true;
				int hot3 = 4;
				while (hot3 > 0) {
					int size2 = que.size();
					for (int j = 0; j < size2; j++) {
						int[] cur2 = que.poll();
						int cr = cur2[0];
						int cc = cur2[1];

						int nr1 = cr - 1;
						int nc1 = cc - 1;
						if (nr1 >= 0 && nr1 < R && nc1 >= 0 && nc1 < C && !v[nr1][nc1] && !wall[nr1][nc1][2]
								&& !wall[nr1 + 1][nc1][1]) {
							que.add(new int[] { nr1, nc1 });
							v[nr1][nc1] = true;
							map[nr1][nc1] += hot3;
						}
						int nr2 = cr - 1;
						int nc2 = cc;
						if (nr2 >= 0 && nr2 < R && nc2 >= 0 && nc2 < C && !v[nr2][nc2] && !wall[nr2][nc2][2]) {
							que.add(new int[] { nr2, nc2 });
							v[nr2][nc2] = true;
							map[nr2][nc2] += hot3;
						}
						int nr3 = cr - 1;
						int nc3 = cc + 1;
						if (nr3 >= 0 && nr3 < R && nc3 >= 0 && nc3 < C && !v[nr3][nc3] && !wall[nr3][nc3][2]
								&& !wall[nr3 + 1][nc3][3]) {
							que.add(new int[] { nr3, nc3 });
							v[nr3][nc3] = true;
							map[nr3][nc3] += hot3;
						}
					}
					hot3--;
				}
				break;
			// 하 온풍기
			case 4:
				r = cur.r + 1;
				c = cur.c;
				map[r][c] += 5;
				que.add(new int[] { r, c });
				v[r][c] = true;
				int hot4 = 4;
				while (hot4 > 0) {
					int size2 = que.size();
					for (int j = 0; j < size2; j++) {
						int[] cur2 = que.poll();
						int cr = cur2[0];
						int cc = cur2[1];

						int nr1 = cr + 1;
						int nc1 = cc - 1;
						if (nr1 >= 0 && nr1 < R && nc1 >= 0 && nc1 < C && !v[nr1][nc1] && !wall[nr1][nc1][0]
								&& !wall[nr1 - 1][nc1][1]) {
							que.add(new int[] { nr1, nc1 });
							v[nr1][nc1] = true;
							map[nr1][nc1] += hot4;
						}
						int nr2 = cr + 1;
						int nc2 = cc;
						if (nr2 >= 0 && nr2 < R && nc2 >= 0 && nc2 < C && !v[nr2][nc2] && !wall[nr2][nc2][0]) {
							que.add(new int[] { nr2, nc2 });
							v[nr2][nc2] = true;
							map[nr2][nc2] += hot4;
						}
						int nr3 = cr + 1;
						int nc3 = cc + 1;
						if (nr3 >= 0 && nr3 < R && nc3 >= 0 && nc3 < C && !v[nr3][nc3] && !wall[nr3][nc3][0]
								&& !wall[nr3 - 1][nc3][3]) {
							que.add(new int[] { nr3, nc3 });
							v[nr3][nc3] = true;
							map[nr3][nc3] += hot4;
						}
					}
					hot4--;
				}
				break;
			}

		}

	}
  //주변과 계산해서 온도 조절하는 함수
	private static void control() {
		// 우 좌 만 비교해서 계산하기
		int[][] temp = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				temp[i][j] = map[i][j];
			}
		}
    
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 우측
				if (j + 1 < C && !wall[i][j][1]) {
					if (map[i][j] > map[i][j + 1]) {
						int sum = (map[i][j] - map[i][j + 1]) / 4;
						temp[i][j] = temp[i][j] - sum;
						temp[i][j + 1] = temp[i][j + 1] + sum;
					} else {
						int sum = (map[i][j + 1] - map[i][j]) / 4;
						temp[i][j] = temp[i][j] + sum;
						temp[i][j + 1] = temp[i][j + 1] - sum;
					}
				}
				// 아래
				if (i + 1 < R && !wall[i][j][2]) {
					if (map[i][j] > map[i + 1][j]) {
						int sum = (map[i][j] - map[i + 1][j]) / 4;
						temp[i][j] = temp[i][j] - sum;
						temp[i + 1][j] = temp[i + 1][j] + sum;
					} else {
						int sum = (map[i + 1][j] - map[i][j]) / 4;
						temp[i][j] = temp[i][j] + sum;
						temp[i + 1][j] = temp[i + 1][j] - sum;
					}
				}
			}
		}

		map = temp;

	}
  //외곽 -1씩 시키는 함수
	private static void outMinus() {
		for (int i = 0; i < C; i++) {
			if (map[0][i] > 0) {
				map[0][i]--;
			}
			if (map[R - 1][i] > 0) {
				map[R - 1][i]--;
			}
		}
		for (int i = 1; i < R - 1; i++) {
			if (map[i][0] > 0) {
				map[i][0]--;
			}
			if (map[i][C - 1] > 0) {
				map[i][C - 1]--;
			}
		}

	}
  //조사할 부분이 K온도 이상인지 체크하는 함수
	private static void check() {
		int size = josa.size();
		boolean temp = true;
		for (int i = 0; i < size; i++) {
			int[] cur = josa.poll();
			josa.add(cur);
			if (map[cur[0]][cur[1]] < K) {
				temp = false;
				break;
			}
		}
		if (temp) {
			can = true;
		}
	}
  //온풍기 클래스
	public static class On {
		int r; // row
		int c; // column
		int d; // 방향 1이면 우 2면 좌 3이면 상 4면 하

		On(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

}
