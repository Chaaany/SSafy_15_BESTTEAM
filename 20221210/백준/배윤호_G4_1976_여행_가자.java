import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean check = true;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i == j) {
					map[i][j] = 1;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int[] route = new int[M];
		for (int i = 0; i < M; i++) {
			route[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][i] == 1 && map[i][k] == 1) {
						map[j][k] = 1;
					}
				}
			}
		}
		for (int i = 0; i < M - 1; i++) {
			if (map[route[i]][route[i + 1]] == 0) {
				check = false;
				break;
			}
		}
		if (check)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
