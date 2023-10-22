import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N < 10) {
			System.out.println(N);
		} else if (N < 100) {
			System.out.println((N - 9) * 2 + 9);
		} else if (N < 1000) {
			System.out.println((N - 99) * 3 + 9 + (2 * 90));
		} else if (N < 10000) {
			System.out.println((N - 999) * 4 + 9 + (2 * 90) + (3 * 900));
		} else if (N < 100000) {
			System.out.println((N - 9999) * 5 + 9 + (2 * 90) + (3 * 900) + (4 * 9000));
		} else if (N < 1000000) {
			System.out.println((N - 99999) * 6 + 9 + (2 * 90) + (3 * 900) + (4 * 9000) + (5 * 90000));
		} else if (N < 10000000) {
			System.out.println((N - 999999) * 7 + 9 + (2 * 90) + (3 * 900) + (4 * 9000) + (5 * 90000) + (6 * 900000));
		} else if (N < 100000000) {
			System.out.println((N - 9999999) * 8 + 9 + (2 * 90) + (3 * 900) + (4 * 9000) + (5 * 90000) + (6 * 900000)
					+ (7 * 9000000));
		} else {
			System.out.println(788888898);
		}
	}

}
