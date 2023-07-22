import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double a = Integer.parseInt(st.nextToken());
		double d = Integer.parseInt(st.nextToken());
		double k = Integer.parseInt(st.nextToken());
		d /= 100;
		k /= 100;

		double ans = 0;
		double notEndRate = 1;
		double pan = 1;

		while (true) {
			ans += pan * a * notEndRate * d;
			pan++;
			if (d == 1) {
				break;
			}
			notEndRate = notEndRate * (1 - d);
			d += d * k;
			if (d >= 1) {
				d = 1;
			}
		}
		System.out.println(String.format("%.7f", ans));
	}

}
