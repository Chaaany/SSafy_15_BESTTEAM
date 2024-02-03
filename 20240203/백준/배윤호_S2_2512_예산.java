import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2512_Budget {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int min = 0;
		int max = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}
		int total = Integer.parseInt(br.readLine());
		if (sum <= total) {
			System.out.println(max);
			return;
		}

		while (min <= max) {
			sum = 0;
			int cur = (min + max) / 2;

			for (int i : arr) {
				if (i > cur) {
					sum += cur;
				} else {
					sum += i;
				}
			}
			if (total >= sum) {
				min = cur + 1;
			} else {
				max = cur - 1;
			}
		}
		System.out.println(max);
	}

}
