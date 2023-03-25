import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_21610_WizardSharkAndRainBaragi {
	static int map[][];
	static int N, M;
	static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] xr = { -1, -1, 1, 1 };
	static int[] xc = { -1, 1, 1, -1 };
	static Queue<int[]> cloud = new LinkedList<int[]>();

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
		cloud.add(new int[] { N - 1, 0 });
		cloud.add(new int[] { N - 1, 1 });
		cloud.add(new int[] { N - 2, 0 });
		cloud.add(new int[] { N - 2, 1 });
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			magic(d, s);
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += map[i][j];
			}
		}
		System.out.println(ans);
	}

	private static void magic(int d, int s) {
		// 구름 이동
		int size = cloud.size();
		for (int i = 0; i < size; i++) {
			int cur[] = cloud.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int j = 0; j < s; j++) {
				cr = cr + dr[d];
				cc = cc + dc[d];
				if (cr >= N) {
					cr = 0;
				}
				if (cr < 0) {
					cr = N - 1;
				}
				if (cc >= N) {
					cc = 0;
				}
				if (cc < 0) {
					cc = N - 1;
				}
			}
			cloud.add(new int[] { cr, cc });
		}
		// 비 내리고 물의 양 1증가, 구름 제거 및 제거 위치 기록, 물이 증가한 칸 큐 생성
		Queue<int[]> rain = new LinkedList<int[]>();
		boolean[][] v = new boolean[N][N];
		while (!cloud.isEmpty()) {
			int[] cur = cloud.poll();
			int cr = cur[0];
			int cc = cur[1];
			map[cr][cc]++;
			v[cr][cc] = true;
			rain.add(new int[] { cr, cc });
		}
		// 물복사 버그 시전
		while (!rain.isEmpty()) {
			int[] cur = rain.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int x = 0; x < 4; x++) {
				int nr = cr + xr[x];
				int nc = cc + xc[x];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] >= 1) {
					map[cr][cc]++;
				}
			}
		}

		// 바구니 저장된 물 2 이상인 칸에 물 2 줄이고 구름 생성, 이 때 이전 단계에서 구름이 사라지지 않은 곳이어야 함.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 2 && !v[i][j]) {
					map[i][j] -= 2;
					cloud.add(new int[] { i, j });
				}
			}
		}
	}

}
