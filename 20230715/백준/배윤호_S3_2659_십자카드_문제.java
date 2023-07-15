import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		String c = st.nextToken();
		String d = st.nextToken();
		int min = 9999;
		min = Math.min(min, Integer.parseInt(a + b + c + d));
		min = Math.min(min, Integer.parseInt(b + c + d + a));
		min = Math.min(min, Integer.parseInt(c + d + a + b));
		min = Math.min(min, Integer.parseInt(d + a + b + c));

		int ans = 1;
		for (int i = 1111; i < min; i++) {
			String s = i + "";
			if (s.contains("0")) {
				continue;
			}
			if (check(s)) {
				ans++;
			}
		}
		System.out.println(ans);

	}

	private static boolean check(String s) {
		int min = Integer.parseInt(s);

		String a = s.charAt(0) + "";
		String b = s.charAt(1) + "";
		String c = s.charAt(2) + "";
		String d = s.charAt(3) + "";

		if (min > Integer.parseInt(a + b + c + d)) {
			return false;
		}
		if (min > Integer.parseInt(b + c + d + a)) {
			return false;
		}
		if (min > Integer.parseInt(c + d + a + b)) {
			return false;
		}
		if (min > Integer.parseInt(d + a + b + c)) {
			return false;
		}

		return true;
	}

}
