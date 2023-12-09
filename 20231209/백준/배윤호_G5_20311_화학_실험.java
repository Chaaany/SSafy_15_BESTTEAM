import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_20311_ChemicalExperiment {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		PriorityQueue<siyak> pq = new PriorityQueue<siyak>();
		Queue<siyak> temp = new LinkedList<>();
		for (int i = 0; i < K; i++) {
			pq.add(new siyak(i + 1, Integer.parseInt(st.nextToken())));
		}
		StringBuilder sb = new StringBuilder();

		siyak cur = pq.poll();
		if (cur.qty == N && N != 1) {
			System.out.println(-1);
			return;
		}
		sb.append(cur.num + " ");
		if (cur.qty - 1 != 0) {
			temp.add(new siyak(cur.num, cur.qty - 1));
		}
		N--;
		int bef = 0;
		while (!pq.isEmpty()) {
			cur = pq.poll();
			if (cur.qty == N && N != 1) {
				System.out.println(-1);
				return;
			}
			sb.append(cur.num + " ");
			bef = cur.num;
			if (cur.qty - 1 != 0) {
				temp.add(new siyak(cur.num, cur.qty - 1));
			}
			if (temp.size() != 0 && temp.peek().num != bef) {
				pq.add(temp.poll());
			}

			N--;
		}
		System.out.println(sb);

	}

	static class siyak implements Comparable<siyak> {
		int num;
		int qty;

		siyak(int num, int qty) {
			this.num = num;
			this.qty = qty;
		}

		@Override
		public int compareTo(siyak o) {
			return o.qty - this.qty;
		}
	}

}
