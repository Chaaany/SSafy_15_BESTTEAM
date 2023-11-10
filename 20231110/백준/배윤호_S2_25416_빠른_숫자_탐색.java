import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[5][5];
		boolean[][] v = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		int time = 0;
		boolean cango = false;
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { sr, sc });
		v[sr][sc] = true;
		go: while (!que.isEmpty()) {
			time++;
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int[] cur = que.poll();
				int r = cur[0];
				int c = cur[1];
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && !v[nr][nc] && map[nr][nc] != -1) {
						if (map[nr][nc] == 1) {
							cango = true;
							break go;
						}
						que.add(new int[] { nr, nc });
						v[nr][nc] = true;
					}
				}
			}
		}
		if (cango) {
			System.out.println(time);
		} else {
			System.out.println(-1);
		}
	}

}
