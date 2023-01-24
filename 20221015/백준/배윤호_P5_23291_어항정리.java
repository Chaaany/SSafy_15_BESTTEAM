import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K = 0;
	static boolean check = false;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] fb = new int[N];
		for (int i = 0; i < N; i++) {
			fb[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		while (true) {
			fb = maxmin(fb);
			if (check) {
				break;
			}
			count++;
			int[][] temp = new int[2][N - 1];
			temp[0][0] = fb[0];
			int index = 0;
			for (int i = 1; i < N; i++) {
				temp[1][index++] = fb[i];
			}
			// 어항 돌리면서 쌓기
			while (true) {
				int over = 0;
				for (int i = 0; i < temp[0].length; i++) {
					if (temp[0][i] > 0) {
						over++;
					}
				}
                
				if (temp.length > temp[0].length - over) {
					break;
				}
				int[][] newtemp = new int[over + 1][temp[0].length - over];
				for (int i = 0; i < over; i++) {
					for (int j = 0; j < temp.length; j++) {
						newtemp[i][j] = temp[temp.length - 1 - j][i];
					}
				}
				index = 0;
				for (int i = over; i < temp[0].length; i++) {
					newtemp[newtemp.length - 1][index++] = temp[temp.length - 1][i];
				}
				temp = newtemp;
			}
			// 물고기 수 조절
			temp = control(temp);
			// 다시 일렬로 놓기
			fb = spread(temp);
			// 반절 잘라서 공중부양 x2
			temp = halfcut(fb);
			temp = control(temp);
			fb = spread(temp);

		}
		System.out.println(count);

	}

	private static int[][] halfcut(int[] fb) {
		int[][] newtemp = new int[2][fb.length / 2];
		int index = (fb.length / 2) - 1;
		for (int i = 0; i < newtemp[0].length; i++) {
			newtemp[0][index--] = fb[i];
		}
		index = 0;
		for (int i = newtemp[0].length; i < fb.length; i++) {
			newtemp[1][index++] = fb[i];
		}

		int[][] newtemp2 = new int[4][fb.length / 4];
		for (int i = 0; i < 2; i++) {
			index = (fb.length / 4) - 1;
			for (int j = 0; j < fb.length / 4; j++) {
				newtemp2[i][j] = newtemp[1 - i][index--];
			}
		}
		for (int i = 2; i < newtemp2.length; i++) {
			for (int j = 0; j < newtemp2[0].length; j++) {
				newtemp2[i][j] = newtemp[i - 2][j + (newtemp[0].length / 2)];
			}
		}
		return newtemp2;
	}

	private static int[] spread(int[][] temp) {
		int[] newtemp = new int[N];
		int index = 0;
		for (int i = 0; i < temp[0].length; i++) {
			for (int j = temp.length - 1; j >= 0; j--) {
				if (temp[j][i] != 0) {
					newtemp[index++] = temp[j][i];
				}
			}
		}
		return newtemp;
	}

	private static int[][] control(int[][] temp) {
		int[][] newtemp = new int[temp.length][temp[0].length];
		for (int i = 0; i < newtemp.length; i++) {
			for (int j = 0; j < newtemp[0].length; j++) {
				newtemp[i][j] = temp[i][j];
			}
		}
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if ((i + j) % 2 != 0 || temp[i][j] == 0)
					continue;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (nr >= 0 && nr < temp.length && nc >= 0 && nc < temp[0].length && temp[nr][nc] != 0) {
						int dif = Math.abs(temp[i][j] - temp[nr][nc]);
						int dd = dif / 5;
						if (dd > 0) {
							if (temp[i][j] > temp[nr][nc]) {
								newtemp[i][j] -= dd;
								newtemp[nr][nc] += dd;
							} else {
								newtemp[i][j] += dd;
								newtemp[nr][nc] -= dd;
							}
						}
					}
				}
			}
		}
		return newtemp;
	}

	private static int[] maxmin(int[] fb) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i : fb) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		if (K >= (max - min)) {
			check = true;
			return fb;
		} else {
			for (int i = 0; i < N; i++) {
				if (fb[i] == min) {
					fb[i]++;
				}
			}
		}
		return fb;
	}

}
