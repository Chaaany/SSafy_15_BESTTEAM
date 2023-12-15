import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17204_TheGameOfDeath {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] v = new boolean[N];
		int[] next = new int[N];
		for (int i = 0; i < N; i++) {
			next[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0;
		int cur = 0;
		while (true) {
			ans++;
			cur = next[cur];
			if (v[cur]) {
				ans = -1;
				break;
			}
			v[cur] = true;
			if (cur == K) {
				break;
			}
		}
		System.out.println(ans);
	}

}
