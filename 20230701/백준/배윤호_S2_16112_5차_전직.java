import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_16112_5chaZeonZik {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		long stone = 0;
		long ans = 0;
		while (!pq.isEmpty()) {
			long quest = pq.poll();
			ans += quest * stone;
			stone++;
			if (stone > k) {
				stone = k;
			}
		}
		System.out.println(ans);

	}

}
