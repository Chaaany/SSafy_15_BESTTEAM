import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N = 0;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		boolean[][] v = new boolean[N][N];
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (N == 1) {
			System.out.println(0);
			return;
		}
		// 경사 최댓값 최소값 찾기
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { 0, 0 });
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
					max = Math.max(max, Math.abs(map[r][c] - map[nr][nc]));
					min = Math.min(min, Math.abs(map[r][c] - map[nr][nc]));
					v[nr][nc] = true;
					que.add(new int[] { nr, nc });
				}
			}
		}
		int mid = 0;
		int ans = Integer.MAX_VALUE;
		// 이분탐색하면서 경로 탐색
		while (min <= max) {
			if (find(mid)) {
				ans = Math.min(ans, mid);
				max = mid - 1;
				mid = (max + min) / 2;
			} else {
				min = mid + 1;
				mid = (max + min) / 2;
			}
		}
		System.out.println(ans);
	}

	private static boolean find(int mid) {
		boolean check = false;
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { 0, 0 });
		boolean[][] v = new boolean[N][N];
		go: while (!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && Math.abs(map[r][c] - map[nr][nc]) <= mid) {
					v[nr][nc] = true;
					que.add(new int[] { nr, nc });
					if (nr == N - 1 && nc == N - 1) {
						check = true;
						break go;
					}
				}
			}
		}

		return check;
	}

}
