import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int jongsooR;
	static int jongsooC;
	static int time = 0;
	static char[][] map;
	static int[][] v;
	static boolean check = false;

//	static List<int[]> crazyRC = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		v = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				char temp = s.charAt(j);
				if (temp == 'I') {
					jongsooR = i;
					jongsooC = j;
				}
				if (temp == 'R') {
					v[i][j] = 1;
				}
			}
		}
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			time++;
			int temp = s.charAt(i) - 48;
			jongsoo(temp);
			crazy();
			if (check) {
				break;
			}
		}
		if (check) {
			System.out.println("kraj " + time);
		} else {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (v[i][j] == 1) {
						map[i][j] = 'R';
					} else {
						map[i][j] = '.';
					}
				}
			}
			map[jongsooR][jongsooC] = 'I';
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static void jongsoo(int temp) {
		switch (temp) {
		case 1:
			if (map[jongsooR + 1][jongsooC - 1] == 'R') {
				check = true;
				break;
			}
			map[jongsooR][jongsooC] = '.';
			map[jongsooR + 1][jongsooC - 1] = 'I';
			jongsooR = jongsooR + 1;
			jongsooC = jongsooC - 1;
			break;
		case 2:
			if (map[jongsooR + 1][jongsooC] == 'R') {
				check = true;
				break;
			}
			map[jongsooR][jongsooC] = '.';
			map[jongsooR + 1][jongsooC] = 'I';
			jongsooR = jongsooR + 1;
			break;
		case 3:
			if (map[jongsooR + 1][jongsooC + 1] == 'R') {
				check = true;
				break;
			}
			map[jongsooR][jongsooC] = '.';
			map[jongsooR + 1][jongsooC + 1] = 'I';
			jongsooR = jongsooR + 1;
			jongsooC = jongsooC + 1;
			break;
		case 4:
			if (map[jongsooR][jongsooC - 1] == 'R') {
				check = true;
				break;
			}
			map[jongsooR][jongsooC] = '.';
			map[jongsooR][jongsooC - 1] = 'I';
			jongsooC = jongsooC - 1;
			break;
		case 5:
			break;
		case 6:
			if (map[jongsooR][jongsooC + 1] == 'R') {
				check = true;
				break;
			}
			map[jongsooR][jongsooC] = '.';
			map[jongsooR][jongsooC + 1] = 'I';
			jongsooC = jongsooC + 1;
			break;
		case 7:
			if (map[jongsooR - 1][jongsooC - 1] == 'R') {
				check = true;
				break;
			}
			map[jongsooR][jongsooC] = '.';
			map[jongsooR - 1][jongsooC - 1] = 'I';
			jongsooR = jongsooR - 1;
			jongsooC = jongsooC - 1;
			break;
		case 8:
			if (map[jongsooR - 1][jongsooC] == 'R') {
				check = true;
				break;
			}
			map[jongsooR][jongsooC] = '.';
			map[jongsooR - 1][jongsooC] = 'I';
			jongsooR = jongsooR - 1;
			break;
		case 9:
			if (map[jongsooR - 1][jongsooC + 1] == 'R') {
				check = true;
				break;
			}
			map[jongsooR][jongsooC] = '.';
			map[jongsooR - 1][jongsooC + 1] = 'I';
			jongsooR = jongsooR - 1;
			jongsooC = jongsooC + 1;
			break;

		}

	}

	private static void crazy() {
		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (v[i][j] == 1) {
					list.add(new int[] { i, j });
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			int r = list.get(i)[0];
			int c = list.get(i)[1];
			int nr = r;
			int nc = c;
			if (r > jongsooR) {
				nr = r - 1;
			} else if (r < jongsooR) {
				nr = r + 1;
			}
			if (c > jongsooC) {
				nc = c - 1;
			} else if (c < jongsooC) {
				nc = c + 1;
			}
			if (nr == jongsooR && nc == jongsooC) {
				check = true;
				return;
			}
			v[r][c]--;
			v[nr][nc]++;
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (v[i][j] > 1) {
					v[i][j] = 0;
				}
			}
		}

	}

}
