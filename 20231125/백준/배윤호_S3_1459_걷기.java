import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long W = Long.parseLong(st.nextToken());
		long S = Long.parseLong(st.nextToken());
		long ans = 0;
		if (W >= S) {
			if ((X + Y) % 2 == 0) {
				ans = Math.max(X, Y) * S;
			} else {
				ans += (Math.max(X, Y) - 1) * S + W;
			}
		} else if (W * 2 < S) {
			ans = (X + Y) * W;
		} else {
			ans = Math.min(X, Y) * S + Math.abs(X - Y) * W;
		}
		System.out.println(ans);

	}

}
