import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1120_String {
	static int min = 50;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		for (int i = 0; i <= B.length() - A.length(); i++) {
			String temp = B.substring(i, i + A.length());
			comp(A, temp);
		}
		System.out.println(min);
	}

	private static void comp(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				count++;
		}
		min = Math.min(min, count);

	}

}
