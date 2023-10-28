import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String input = br.readLine();
			if (input == null)
				break;
			int N = Integer.parseInt(input);
			int leng = (int) Math.pow(3, N);
			v = new boolean[leng];
			for (int i = 0; i < leng; i++) {
				v[i] = true;
			}
			find(N, 0, leng / 3, (leng * 2) / 3);
			for (int i = 0; i < leng; i++) {
				if (v[i])
					sb.append("-");
				else
					sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void find(int n, int first, int second, int third) {
		if (n == 0)
			return;
		for (int i = second; i < third; i++) {
			v[i] = false;
		}
		n--;
		find(n, first, first + ((int) Math.pow(3, n) / 3), first + ((int) (Math.pow(3, n) * 2) / 3));
		find(n, third, third + ((int) Math.pow(3, n) / 3), third + ((int) (Math.pow(3, n) * 2) / 3));
	}

}
