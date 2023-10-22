import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		PriorityQueue<Bob> pq = new PriorityQueue<>();
		int ans = 0;
		int money = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.add(new Bob(a, b));
			ans += b;
			money += 1000;
		}

		for (int i = 0; i < N; i++) {
			Bob bob = pq.poll();
			if (bob.b > bob.a)
				break;
			if (X >= money + 4000) {
				ans = ans - bob.b + bob.a;
				money += 4000;
			}
			if (X < money + 4000) {
				break;
			}
		}

		System.out.println(ans);
	}

	static class Bob implements Comparable<Bob> {
		int a;
		int b;

		Bob(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Bob bob) {
			int gap1 = this.a - this.b;
			int gap2 = bob.a - bob.b;
			return gap2 - gap1;
		}

	}

}
