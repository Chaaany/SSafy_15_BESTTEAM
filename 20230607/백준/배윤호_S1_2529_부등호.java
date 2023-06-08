import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2529_NotEquals {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		char[] c = new char[k]; // 부등호 담을 배열
		boolean[] v = new boolean[10]; // 0 ~ 9 check;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			c[i] = st.nextToken().charAt(0);
		}
		String max = "";
		for (int i = 0; i < k + 1; i++) {
			int start = 0;
			for (int j = 9; j >= 0; j--) {
				if (!v[j]) {
					start = j;
					break;
				}
			}
			for (int j = i; j < k; j++) {
				if (c[j] == '>') {
					break;
				}
				start--;
			}
			max += start;
			v[start] = true;

		}
		v = new boolean[10]; // 0 ~ 9 check;
		String min = "";
		for (int i = 0; i < k + 1; i++) {
			int start = 0;
			for (int j = 0; j <= 9; j++) {
				if (!v[j]) {
					start = j;
					break;
				}
			}
			for (int j = i; j < k; j++) {
				if (c[j] == '<') {
					break;
				}
				start++;
			}
			min += start;
			v[start] = true;

		}
		System.out.println(max);
		System.out.println(min);
	}

}
