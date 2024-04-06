import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] DNA = new char[N][M];
		for (int i = 0; i < N; i++) {
			DNA[i] = br.readLine().toCharArray();
		}
		int difSum = 0;
		for (int i = 0; i < M; i++) {
			char minAlphabet = 65;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < 26; j++) {
				int a = 65 + j;
				char b = (char) a;
				int dif = 0;
				for (int k = 0; k < N; k++) {
					if (b != DNA[k][i]) {
						dif++;
					}
				}
				if (dif < min) {
					min = dif;
					minAlphabet = b;
				}
			}
			difSum += min;
			sb.append(minAlphabet);
		}
		sb.append("\n");
		sb.append(difSum);
		System.out.println(sb);

	}

}
