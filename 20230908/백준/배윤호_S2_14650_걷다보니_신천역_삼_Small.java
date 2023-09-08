import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int ans;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(0);
			return;
		}
		find(1, 1, 1); // 숫자, 자리수, 자리수 합
		find(2, 1, 2); // 숫자, 자리수, 자리수 합
		System.out.println(ans);
	}

	private static void find(int num, int zari, int sum) {
		if (zari == N) {
			if (sum % 3 == 0) {
				ans++;
			}
			return;
		}
		find(0, zari + 1, sum + 0);
		find(1, zari + 1, sum + 1);
		find(2, zari + 1, sum + 2);

	}

}
