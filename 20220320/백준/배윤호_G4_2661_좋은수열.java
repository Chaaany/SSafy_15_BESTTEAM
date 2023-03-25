import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static String answer;
	static boolean b = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		find("1");
		System.out.println(answer);
	}

	private static void find(String s) {
		if (b)
			return;
		boolean v = check(s);
		if (v) {
			if (s.length() == N) {
				answer = s;
				b = true;
				return;
			}
			for (int i = 1; i <= 3; i++) {
				find(s + i);
			}
		}

	}

	private static boolean check(String s) {
		boolean v = true;
		if (s.length() > 1) {
			int l = 1;
			while (l <= s.length() / 2) {
				for (int i = 0; i <= s.length() - l * 2; i++) {
					if (s.substring(i, i + l).equals(s.substring(i + l, i + l + l))) {
						v = false;
						break;
					}
				}
				l++;
			}
		}
		return v;
	}

}
