import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_21608_SharkElementarySchool {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N;
	static int[][] map, friends;
	static int satisfaction = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		friends = new int[N * N + 1][4];
		StringTokenizer st;
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			friends[student][0] = Integer.parseInt(st.nextToken());
			friends[student][1] = Integer.parseInt(st.nextToken());
			friends[student][2] = Integer.parseInt(st.nextToken());
			friends[student][3] = Integer.parseInt(st.nextToken());
			seat(student);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				getHappy(i, j);
			}
		}
		System.out.println(satisfaction);
	}

	private static void getHappy(int r, int c) {
		int student = map[r][c];
		int friend = 0;
		int happy = 1;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				for (int f = 0; f < 4; f++) {
					if (map[nr][nc] == friends[student][f])
						friend++;
				}
			}
		}
		if (friend != 0) {
			for (int i = 0; i < friend - 1; i++) {
				happy *= 10;
			}
			satisfaction += happy;
		}
	}

	private static void seat(int student) {
		int seatr = 0;
		int seatc = 0;
		int maxfriend = 0;
		int maxblank = 0;
		go: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					seatr = i;
					seatc = j;
					break go;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0)
					continue;
				int friend = 0;
				int blank = 0;
				int r = i;
				int c = j;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (map[nr][nc] == 0)
							blank++;
						else {
							for (int f = 0; f < 4; f++) {
								if (map[nr][nc] == friends[student][f]) {
									friend++;
								}
							}
						}
					}
					if (maxfriend < friend) {
						seatr = r;
						seatc = c;
						maxfriend = friend;
						maxblank = blank;
					} else if (maxfriend == friend && maxblank < blank) {
						seatr = r;
						seatc = c;
						maxblank = blank;
					}
				}
			}
		}
		map[seatr][seatc] = student;
	}

}
