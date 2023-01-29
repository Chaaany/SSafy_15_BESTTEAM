import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] sosu = new int[283147];
		boolean[] v;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		v = new boolean[N + 1];
		v[1] = true;
		for (int i = 2; i * i <= N; i++) {
			if (!v[i]) {
				for (int j = i * i; j <= N; j += i)
					v[j] = true;
			}
		}
		int index = 0;
		for (int i = 1; i < N + 1; i++) {
			if (!v[i]) {
				sosu[index++] = i;
			}
		}
		int left = 0;
		int right = 0;
		int sum = 2;
		int count = 0;
		while (left < index && right < index) {
			if (sum < N) {
				right++;
				sum += sosu[right];
			} else if (sum > N) {
				sum -= sosu[left];
				left++;
			} else if (sum == N) {
				count++;
				right++;
				sum += sosu[right];

			}
		}
		System.out.println(count);

	}

}
