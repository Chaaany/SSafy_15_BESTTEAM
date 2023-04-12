import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1946_OnBoarding {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 1;
			PriorityQueue<Officer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.resume, o2.resume));
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				pq.add(new Officer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Officer o = pq.poll();
			int r = o.resume;
			int i = o.interview;
			while (!pq.isEmpty()) {
				Officer officer = pq.poll();
				if (officer.resume > r && officer.interview > i) {
					continue;
				}
				ans++;
				r = officer.resume;
				i = officer.interview;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	public static class Officer {
		int resume;
		int interview;

		Officer(int resume, int interview) {
			this.resume = resume;
			this.interview = interview;
		}
	}

}
