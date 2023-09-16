import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[][] map;
	static int N;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				change(i, j);
			}
		}
		System.out.println(max);

	}

	private static void change(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[r][c] != map[nr][nc]) {
				char temp = map[r][c];
				map[r][c] = map[nr][nc];
				map[nr][nc] = temp;
				check();
				temp = map[r][c];
				map[r][c] = map[nr][nc];
				map[nr][nc] = temp;
			}
		}

	}

	private static void check() {
		int count = 1;

		for (int i = 0; i < N; i++) {
			int temp = 1;
			for (int j = 1; j < N; j++) {
				if (map[i][j] == map[i][j - 1]) {
					temp++;
				} else
					temp = 1;
				count = Math.max(count, temp);
			}
		}

		for (int i = 0; i < N; i++) {
			int temp = 1;
			for (int j = 1; j < N; j++) {
				if (map[j][i] == map[j - 1][i]) {
					temp++;
				} else
					temp = 1;
				count = Math.max(count, temp);
			}
		}
		max = Math.max(max, count);
	}

}
