import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	static long[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		arr = new long[t];

		for (int i = 0; i < t; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		find();
	}

	private static void find() {
		for (int i = 0; i < arr.length; i++) {
			BigInteger cur = new BigInteger(String.valueOf(arr[i]));
			if (cur.isProbablePrime(10)) {
				System.out.println(cur);
			} else {
				System.out.println(cur.nextProbablePrime());
			}
		}

	}

}
