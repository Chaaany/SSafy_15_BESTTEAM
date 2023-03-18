import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1105_팔 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String L = st.nextToken();
		String R = st.nextToken();
		int answer = 0;
		if (L.length() == R.length()) {
			for (int i = 0; i < L.length(); i++) {
				if (L.charAt(i) == '8' && R.charAt(i) == '8') {
					answer++;
				} else if (L.charAt(i) != R.charAt(i))
					break;
			}
		}
		System.out.println(answer);
	}

}
