import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int left = 1;
		int right = k;
		int ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				sum += Math.min(N, mid / i);
			}
			if (sum >= k) {
				right = mid - 1;
				ans = mid;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(ans);

	}

}
