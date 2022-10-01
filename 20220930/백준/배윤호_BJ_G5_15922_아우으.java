import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int nextStart = Integer.parseInt(st.nextToken());
			int nextEnd = Integer.parseInt(st.nextToken());
			if (nextStart <= end) {
				if (nextEnd > end) {
					end = nextEnd;
				}
			} else {
				answer += (end - start);
				start = nextStart;
				end = nextEnd;
			}
		}
		answer += (end - start);
		System.out.println(answer);
	}
}
