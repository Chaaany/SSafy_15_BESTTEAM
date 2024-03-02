import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int front = 0;
		int back = N - 1;
		int ans = 0;
		while (back > front) {
			if (arr[front] + arr[back] == M) {
				ans++;
				front++;
				back--;
			} else if (arr[front] + arr[back] > M) {
				back--;
			} else {
				front++;
			}
		}
		System.out.println(ans);
	}

}
