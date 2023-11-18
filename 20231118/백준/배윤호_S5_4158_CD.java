import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			int[] arr = new int[100000001];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) {
				break;
			}
			for (int i = 0; i < N; i++) {
				int a = Integer.parseInt(br.readLine());
				arr[a]++;
			}
			int ans = 0;
			for (int i = 0; i < M; i++) {
				int a = Integer.parseInt(br.readLine());
				if (arr[a] == 1) {
					ans++;
				}
			}
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
