import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12847_HoneyPartTimer {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Long[] pay = new Long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pay[i] = Long.parseLong(st.nextToken());
		}
		long max = 0;
		long temp = 0;
		for (int i = 0; i < m; i++) {
			temp += pay[i];
		}
		max = temp;
		for (int i = 0; i < n - m; i++) {
			temp = temp - pay[i] + pay[m + i];
			max = Math.max(max, temp);
		}
		System.out.println(max);
	}

}
