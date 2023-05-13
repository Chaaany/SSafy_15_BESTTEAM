import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1261_AlgoSpot {
	static int R, C;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int min = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j) - 48;
			}
		}
		bfs(0, 0);
		System.out.println(min);
	}

	public static void bfs(int i, int j) {
		PriorityQueue<road> pq = new PriorityQueue<>((r1, r2) -> Integer.compare(r1.count, r2.count));
		boolean[][] v = new boolean[R][C];
		pq.offer(new road(0, 0, 0));
		v[0][0] = true;
		while (!pq.isEmpty()) {
			road cur = pq.poll();
			if (cur.r == R - 1 && cur.c == C - 1) {
				min = cur.count;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !v[nr][nc]) {
					if (map[nr][nc] == 0) {
						v[nr][nc] = true;
						pq.offer(new road(nr, nc, cur.count));
					} else if (map[nr][nc] == 1) {
						v[nr][nc] = true;
						pq.offer(new road(nr, nc, cur.count + 1));
					}
				}
			}
		}
	}

	public static class road {
		int r;
		int c;
		int count;

		road(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}
}
