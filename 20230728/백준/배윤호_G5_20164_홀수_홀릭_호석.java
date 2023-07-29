import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		find(N, 0);
		System.out.println(min + " " + max);
	}

	private static void find(int n, int count) {
		String s = n + "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) % 2 != 0) {
				count++;
			}
		}
		if (s.length() == 1) {
			min = Math.min(min, count);
			max = Math.max(max, count);
			return;
		} else if (s.length() == 2) {
			int temp = s.charAt(0) - 48 + s.charAt(1) - 48;
			find(temp, count);
		} else {
			for (int i = 1; i < s.length() - 1; i++) {
				for (int j = i + 1; j < s.length(); j++) {
					int a = Integer.parseInt(s.substring(0, i));
					int b = Integer.parseInt(s.substring(i, j));
					int c = Integer.parseInt(s.substring(j, s.length()));
					find(a + b + c, count);
				}
			}
		}

	}

}
