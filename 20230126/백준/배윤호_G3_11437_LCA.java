import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_11437_LCA {
	static int N;
	static int[] parents;
	static boolean[] v;
	static ArrayList<Integer>[] link;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parents = new int[N + 1];
		v = new boolean[N + 1];
		link = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			link[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			link[a].add(b);
			link[b].add(a);
		}
		v[1] = true;
		p(1);
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			find(a, b);
		}
		System.out.println(sb);
	}

	private static void find(int a, int b) {
		ArrayList<Integer> rootA = new ArrayList<>();
		ArrayList<Integer> rootB = new ArrayList<>();
		rootA.add(a);
		rootB.add(b);
		while (parents[a] != a) {
			rootA.add(parents[a]);
			a = parents[a];
		}
		while (parents[b] != b) {
			rootB.add(parents[b]);
			b = parents[b];
		}
		int indexA = rootA.size() - 1;
		int indexB = rootB.size() - 1;
		while (indexA >= 0 && indexB >= 0) {
			if (!rootA.get(indexA).equals(rootB.get(indexB))) {
				sb.append(rootA.get(indexA + 1)).append("\n");
				return;
			}
			indexA--;
			indexB--;
		}
		if (indexA < 0) {
			sb.append(rootA.get(0)).append("\n");
		} else {
			sb.append(rootB.get(0)).append("\n");
		}

	}

	private static void p(int node) {
		for (int i = 0; i < link[node].size(); i++) {
			int a = link[node].get(i);
			if (v[a]) {
				parents[node] = a;
				continue;
			}
			v[a] = true;
			p(a);
		}
	}

}
