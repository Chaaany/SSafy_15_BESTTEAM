import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int sum = 0;
		int ans = 0;

		while (end < N) {
			if (sum + arr[end] <= M) {
				sum += arr[end];
				ans = Math.max(ans, sum);
				end++;
			} else {
				sum -= arr[start];
				start++;
			}
			if (start > end) {
				sum += arr[end];
				end++;
			}
		}

		System.out.println(ans);

	}

}
