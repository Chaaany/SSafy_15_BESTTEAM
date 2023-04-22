import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] pay = new long[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			pay[i] = pay[i-1] + Long.parseLong(st.nextToken());
		}
		
		long max = 0;
		for (int i = m; i <= n ; i++) {
			max = Math.max(max, pay[i] - pay[i-m]);
		}
		
		System.out.println(max);
	}

}
