import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1719_CJ대한통운한진택배로젠택배롯데택배 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n + 1][n + 1];
		int[][] route = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i == j)
					continue;
				map[i][j] = Integer.MAX_VALUE / 10;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			map[s][e] = d;
			map[e][s] = d;

			route[s][e] = s;
			route[e][s] = e;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				for (int k = 1; k < n + 1; k++) {
					if (map[j][k] > map[j][i] + map[i][k]) {
						map[j][k] = map[j][i] + map[i][k];
						route[j][k] = route[i][k];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (route[i][j] == 0) {
					sb.append("-");
				} else {
					sb.append(route[j][i]);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
