import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] arr;
	static int N;
	static int leng;
	static int min = 0;
	static boolean[] v;
	static boolean check = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String s = N + "";
		leng = s.length();
		arr = new int[leng];
		v = new boolean[leng];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i) - 48;
		}
		Arrays.sort(arr);
		find(0, 0);
		System.out.println(min);
	}

	private static void find(int zari, int cur) {
		if (check) {
			return;
		}
		if (leng == zari) {
			if (cur > N) {
				min = cur;
				check = true;
				return;
			}
		}
		for (int i = 0; i < leng; i++) {
			if (v[i])
				continue;
			v[i] = true;
			find(zari + 1, cur + arr[i] * (int) Math.pow(10, leng - zari - 1));
			v[i] = false;
		}
	}

}
