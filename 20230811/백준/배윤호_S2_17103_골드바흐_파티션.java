import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		boolean[] v = new boolean[1000001];
		v[1] = true;
		for (int i = 2; i * i <= 1000000; i++) {
			if (!v[i]) {
				for (int j = i * i; j <= 1000000; j += i)
					v[j] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			for (int i = 2; i <= N / 2; i++) {
				if (!v[i] && !v[N - i]) {
					ans++;
				}
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb);

	}

}
