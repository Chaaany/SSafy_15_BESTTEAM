import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] ans = new int[N];
		for (int i = 0; i < N; i++) {
			int left = Integer.parseInt(st.nextToken());
			int temp = N - i - left - 1;
			int index = N - 1;
			while (temp > 0) {
				if (ans[index] == 0) {
					temp--;
				}
				index--;
			}
			while (true) {
				if (ans[index] == 0) {
					ans[index] = i + 1;
					break;
				}
				index--;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i : ans) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}

}
