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
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<word> pq = new PriorityQueue<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (s.length() < M)
				continue;
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		for (String s : map.keySet()) {
			pq.add(new word(s, map.get(s)));
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			sb.append(pq.poll().s).append("\n");
		}
		System.out.println(sb);
	}

	static class word implements Comparable<word> {
		String s;
		int cnt;

		word(String s, int cnt) {
			this.s = s;
			this.cnt = cnt;

		}

		@Override
		public int compareTo(word o) {
			if (this.cnt < o.cnt) {
				return 1;
			} else if (this.cnt > o.cnt) {
				return -1;
			} else {
				if (this.s.length() < o.s.length()) {
					return 1;
				} else if (this.s.length() > o.s.length()) {
					return -1;
				} else {
					return this.s.compareTo(o.s);
				}
			}
		}
	}

}
