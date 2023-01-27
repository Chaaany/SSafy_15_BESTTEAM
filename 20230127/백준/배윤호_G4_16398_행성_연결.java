import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16398_PlanetLink {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] map = new int[N][N];
		boolean[] v = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		v[0] = true;
		int count = 1;
		long sum = 0;
		int index = 0;
		while (count < N) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				if (v[i])
					continue;
				if (min > map[0][i]) {
					min = map[0][i];
					index = i;
				}
			}
			v[index] = true;
			sum += min;
			for (int i = 0; i < N; i++) {
				if (v[i])
					continue;
				map[0][i] = Math.min(map[0][i], map[index][i]);
			}
			count++;
		}
		System.out.println(sum);

	}

}
