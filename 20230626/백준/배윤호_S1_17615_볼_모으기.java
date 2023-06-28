import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_17615_BallCollect {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int red = 0;
		int blue = 0;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == 'R') {
				red++;
			} else {
				blue++;
			}
		}
		// 레드를 다 왼쪽으로
		int lr = 0;
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == 'R') {
				lr++;
			} else {
				break;
			}
		}
		ans = Math.min(ans, red - lr);
		// 레드를 다 오른쪽으로
		int rr = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (s.charAt(i) == 'R') {
				rr++;
			} else {
				break;
			}
		}
		ans = Math.min(ans, red - rr);
		// 블루를 다 왼쪽으로
		int lb = 0;
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == 'B') {
				lb++;
			} else {
				break;
			}
		}
		ans = Math.min(ans, blue - lb);
		// 블루를 다 오른쪽으로
		int rb = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (s.charAt(i) == 'B') {
				rb++;
			} else {
				break;
			}
		}
		ans = Math.min(ans, blue - rb);
		System.out.println(ans);
	}

}
