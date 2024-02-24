import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] matches;
	static boolean isEndGame = false;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int tc = 4;

		matches = new int[15][2];
		int index = 0;
		for (int i = 0; i < 6 - 1; i++) {
			for (int j = i + 1; j < 6; j++) {
				matches[index][0] = i;
				matches[index][1] = j;
				index++;
			}
		}

		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			int[][] worldCup = new int[3][6];
			boolean isPossible = true;

			for (int i = 0; i < 6; i++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());

				worldCup[0][i] = win;
				worldCup[1][i] = draw;
				worldCup[2][i] = lose;

				if (win + draw + lose != 5) {
					isPossible = false;
					break;
				}
			}

			if (isPossible) {
				find(worldCup, 0, 15);
				if (isEndGame) {
					sb.append(1);
				} else {
					sb.append(0);
				}
			} else {
				sb.append(0);
			}

			sb.append(" ");
			isEndGame = false;
		}

		System.out.print(sb);
	}

	static void find(int[][] worldCup, int matchCount, int size) {
		if (isEndGame) {
			return;
		}

		if (matchCount == size) {
			isEndGame = true;
			return;
		}

		int myTeam = matches[matchCount][0];
		int enemyTeam = matches[matchCount][1];

		if (worldCup[0][myTeam] > 0 && worldCup[2][enemyTeam] > 0) {
			worldCup[0][myTeam]--;
			worldCup[2][enemyTeam]--;
			find(worldCup, matchCount + 1, size);
			worldCup[0][myTeam]++;
			worldCup[2][enemyTeam]++;
		}
		if (worldCup[1][myTeam] > 0 && worldCup[1][enemyTeam] > 0) {
			worldCup[1][myTeam]--;
			worldCup[1][enemyTeam]--;
			find(worldCup, matchCount + 1, size);
			worldCup[1][myTeam]++;
			worldCup[1][enemyTeam]++;
		}
		if (worldCup[2][myTeam] > 0 && worldCup[0][enemyTeam] > 0) {
			worldCup[2][myTeam]--;
			worldCup[0][enemyTeam]--;
			find(worldCup, matchCount + 1, size);
			worldCup[2][myTeam]++;
			worldCup[0][enemyTeam]++;
		}
	}

}
