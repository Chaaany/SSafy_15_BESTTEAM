import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			List<Com>[] list = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {
				list[i] = new ArrayList<Com>();
			}
			int[] times = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				times[i] = Integer.MAX_VALUE;
			}
			boolean[] v = new boolean[n + 1];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				list[b].add(new Com(a, s));
			}
			v[c] = true;
			PriorityQueue<Com> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.time, n2.time));
			pq.add(new Com(c, 0));
			times[c] = 0;
			while (!pq.isEmpty()) {
				Com cur = pq.poll();
				if (times[cur.index] < cur.time)
					continue;

				for (int i = 0; i < list[cur.index].size(); i++) {
					Com next = list[cur.index].get(i);
					if (times[next.index] > cur.time + next.time) {
						times[next.index] = cur.time + next.time;
						pq.add(new Com(next.index, times[next.index]));
					}
				}
			}
			int infected = 0;
			int max = 0;
			for (int i = 1; i < n + 1; i++) {
				if (times[i] == Integer.MAX_VALUE) {
					continue;
				}
				infected++;
				if (max < times[i]) {
					max = times[i];
				}
			}
			sb.append(infected + " " + max);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static class Com {
		int index;
		int time;

		Com(int index, int time) {
			this.index = index;
			this.time = time;
		}
	}

}
