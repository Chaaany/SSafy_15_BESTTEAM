import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[] time = new int[100000];
		int finish = 0;
		int maxS = 0;
		int maxE = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(br.readLine());
			for (int j = 0; j < t - 1; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				for (int k = s; k < e; k++) {
					time[k]++;
				}
			}
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for (int j = s; j < e; j++) {
				time[j]++;
			}
			finish = Math.max(finish, e);
		}
		int s = 0;
		int e = T;
		maxS = 0;
		maxE = T;
		int sum = 0;
		for (int i = 0; i < T; i++) {
			sum += time[i];
		}
		max = sum;
		s++;
		e++;
		while (e <= finish) {
			sum -= time[s - 1];
			sum += time[e - 1];
			if (sum > max) {
				max = sum;
				maxS = s;
				maxE = e;
			}
			s++;
			e++;
		}
		System.out.println(maxS + " " + maxE);
	}
}
