import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int count = 0;
		char map[][] = new char[R][C];
		int time[][] = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'O') {
					time[i][j] = 3;
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (time[i][j] != 0) {
					time[i][j]--;
				}
			}
		}

		while (true) {
			count++;
			if (count == N)
				break;

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == '.') {
						map[i][j] = 'O';
						time[i][j] = 3;
					} else {
						time[i][j]--;
					}
				}
			}

			count++;
			if (count == N)
				break;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (time[i][j] != 0) {
						time[i][j]--;
						if (time[i][j] == 0) {
							map[i][j] = '.';
							for (int d = 0; d < 4; d++) {
								int x = i + dr[d];
								int y = j + dc[d];
								if (x >= 0 && x < R && y >= 0 && y < C) {
									map[x][y] = '.';
								}
							}
						}
					}
				}
			}

		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();

	}

}
