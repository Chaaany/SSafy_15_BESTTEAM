import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_17241_Pineapple_Advertising {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		boolean[] v = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start].add(end);
			graph[end].add(start);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int n = Integer.parseInt(br.readLine());
			int ans = 1;
			if (v[n]) {
				ans = 0;
			}
			v[n] = true;
			int size = graph[n].size();
			for (int j = size - 1; j >= 0; j--) {
				int temp = graph[n].get(j);
				if (v[temp]) {
					graph[n].remove(j);
				}
				if (!v[temp]) {
					v[temp] = true;
					ans++;
				}
			}
			sb.append(ans).append("\n");

		}
		System.out.println(sb);
	}

}
