import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1325_EfficientHacking {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
//		boolean[] root = new boolean[N + 1];
		int[] cnt = new int[N + 1];
		ArrayList<ArrayList<Integer>> branch = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			branch.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
//			root[a] = true;
			branch.get(b).add(a);
		}
		int max = 0;
		for (int i = 1; i < N + 1; i++) {
			int temp = 0;
//			if (!root[i]) {
			boolean[] v = new boolean[N + 1];
			v[i] = true;
			Queue<Integer> que = new LinkedList<>();
			que.add(i);
			while (!que.isEmpty()) {
				int size = que.size();
				temp += size;
				for (int j = 0; j < size; j++) {
					int cur = que.poll();
					for (int k : branch.get(cur)) {
						if (v[k])
							continue;
						v[k] = true;
						que.add(k);
					}
				}
			}
//			}
			cnt[i] = temp;
			max = Math.max(max, temp);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i < N + 1; i++) {
			if (cnt[i] == max) {
				pq.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			sb.append(pq.poll() + " ");
		}
		System.out.println(sb);
	}

}
