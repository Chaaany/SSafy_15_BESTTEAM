import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N - 1];
		int[] o = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			o[i] = Integer.parseInt(st.nextToken());
		}
		long sum = 0;
		long minCost = o[0];

		for (int i = 0; i < N - 1; i++) {

			if (o[i] < minCost) {
				minCost = o[i];
			}
			sum += (minCost * d[i]); // 총 비용 누적 합
		}
		System.out.println(sum);

	}

}
