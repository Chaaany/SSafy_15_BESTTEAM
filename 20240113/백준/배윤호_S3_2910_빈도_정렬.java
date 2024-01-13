import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> firstAppear = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			map.put(n, map.getOrDefault(n, 0) + 1);
			firstAppear.put(n, firstAppear.getOrDefault(n, i));
		}
		PriorityQueue<beando> pq = new PriorityQueue<>();
		for (int a : map.keySet()) {
			pq.add(new beando(a, map.get(a), firstAppear.get(a)));
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			beando cur = pq.poll();
			for (int i = 0; i < cur.cnt; i++) {
				sb.append(cur.num + " ");
			}
		}
		System.out.println(sb);
	}

	static class beando implements Comparable<beando> {
		int num;
		int cnt;
		int apper;

		beando(int num, int cnt, int appear) {
			this.num = num;
			this.cnt = cnt;
			this.apper = appear;
		}

		@Override
		public int compareTo(beando o) {
			if (o.cnt == this.cnt) {
				return this.apper - o.apper;
			}
			return o.cnt - this.cnt;
		}
	}

}
