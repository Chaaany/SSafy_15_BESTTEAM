import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11581_GuHoMulZa {
	static int N;
	static List<Integer>[] graph;
	static boolean[] v;
	static boolean cycle = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		v = new boolean[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < N; i++) {
			int C = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		dfs(1);
		System.out.println(cycle ? "CYCLE" : "NO CYCLE");
	}

	private static void dfs(int cur) {
		if (v[cur]) {
			cycle = true;
			return;
		}

		v[cur] = true;
		for (int next : graph[cur]) {
			if (v[next]) {
				cycle = true;
				return;
			}
			dfs(next);
		}

		v[cur] = false;
	}

}
