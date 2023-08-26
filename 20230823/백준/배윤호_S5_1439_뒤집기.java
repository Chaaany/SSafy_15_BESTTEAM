import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int zero = 0;
		int one = 0;

		if (arr[0] == '0')
			zero++;
		else
			one++;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				if (arr[i + 1] == '0')
					zero++;
				else
					one++;
			}
		}
		System.out.println(Math.min(zero, one));
	}

}
