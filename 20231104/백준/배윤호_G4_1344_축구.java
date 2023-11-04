import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1344_Soccer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double a = Double.parseDouble(br.readLine()) / 100;
		double b = Double.parseDouble(br.readLine()) / 100;
		double ans = 1;
		double sumA = 0;
		double sumB = 0;
		for (int i = 0; i < 19; i++) {
			if (i == 2 || i == 3 || i == 5 || i == 7 || i == 11 || i == 13 || i == 17)
				continue;
			sumA += combi(18, i) * Math.pow(a, i) * Math.pow(1 - a, 18 - i);
			sumB += combi(18, i) * Math.pow(b, i) * Math.pow(1 - b, 18 - i);
		}
		ans -= (sumA * sumB);
		System.out.println(ans);
	}

	private static double combi(int d, int c) {
		double com = 1;
		int temp = 1;
		for (int i = d; i > (d - c); i--) {
			com *= i;
			com /= temp++;
		}
		return com;
	}

}
