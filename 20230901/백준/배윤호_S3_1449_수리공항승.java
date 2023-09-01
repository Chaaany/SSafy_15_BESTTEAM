import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1449_RepairmanHangSeung {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		int ans = 1;
		float before = pq.poll() - 0.5f + L;
		while (!pq.isEmpty()) {
			int temp = pq.poll();
			if (temp <= before) {
				continue;
			} else {
				ans++;
				before = temp - 0.5f + L;
			}
		}
		System.out.println(ans);
	}

}
