import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[] cs; // characters
	static int[] alpha = new int[26];
	static int ans = 0;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cs = br.readLine().toCharArray();
		N = cs.length;
		for (int i = 0; i < N; i++) {
			alpha[cs[i] - 'a']++;
		}
		find(0, ' ');
		System.out.println(ans);
	}

	private static void find(int cnt, char prev) {
		if (cnt == N) {
			ans++;
			return;
		}
		for (int i = 0; i < 26; i++) {
			if (alpha[i] > 0 && prev != (char) (i + 'a')) {
				alpha[i]--;
				find(cnt + 1, (char) (i + 'a'));
				alpha[i]++;
			}
		}

	}

}
