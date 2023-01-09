import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int left = 0;
		int right = 0;
		int answer = 200;
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (left <= 200 && right <= 200) {
			boolean check = false;
			if (map[0][0] < left || map[0][0] > right) {
				right++;
				continue;
			}
			Queue<int[]> que = new LinkedList<>();
			boolean[][] v = new boolean[n][n];
			que.add(new int[] { 0, 0 });
			v[0][0] = true;
			while (!que.isEmpty()) {
				int cur[] = que.poll();
				int cr = cur[0];
				int cc = cur[1];
				if (cr == n - 1 && cc == n - 1) {
					check = true;
					break;
				}
				for (int d = 0; d < 4; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					if (nr >= 0 && nr < n && nc >= 0 && nc < n && !v[nr][nc] && map[nr][nc] >= left
							&& map[nr][nc] <= right) {
						que.add(new int[] { nr, nc });
						v[nr][nc] = true;
					}
				}
			}

			if (check) {
				answer = Math.min(answer, right - left);
				left++;
			} else {
				right++;
			}
		}
		System.out.println(answer);
	}
}
