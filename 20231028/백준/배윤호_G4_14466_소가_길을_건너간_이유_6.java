import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		List<Integer> island = new ArrayList<>();
		List<int[]> cow = new ArrayList<int[]>();
		int[][] map = new int[N][N];
		boolean[][] v = new boolean[N][N];
		Map<String, Integer> load = new HashMap<>();
		int ans = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken()) - 1;
			int c1 = Integer.parseInt(st.nextToken()) - 1;
			int r2 = Integer.parseInt(st.nextToken()) - 1;
			int c2 = Integer.parseInt(st.nextToken()) - 1;
			load.put(r1 + "," + c1 + "," + r2 + "," + c2, 1);
			load.put(r2 + "," + c2 + "," + r1 + "," + c1, 1);
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1;
			cow.add(new int[] { r, c });
		}
		for (int i = 0; i < K; i++) {
			int[] curCow = cow.get(i);
			int r = curCow[0];
			int c = curCow[1];
			if (v[r][c])
				continue;
			v[r][c] = true;
			int count = 1;
			Queue<int[]> que = new LinkedList<>();
			que.add(new int[] { r, c });
			while (!que.isEmpty()) {
				int[] cur = que.poll();
				int cr = cur[0];
				int cc = cur[1];
				for (int d = 0; d < 4; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
						String s = cr + "," + cc + "," + nr + "," + nc;
						if (load.get(s) != null)
							continue;
						v[nr][nc] = true;
						que.add(new int[] { nr, nc });
						if (map[nr][nc] == 1)
							count++;
					}
				}
			}
			island.add(count);
		}
		for (int i = 0; i < island.size(); i++) {
			for (int j = i + 1; j < island.size(); j++) {
				ans += island.get(i) * island.get(j);
			}
		}
		if (island.size() == 1) {
			ans = 0;
		}
		System.out.println(ans);
	}

}
