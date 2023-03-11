import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int index = 1;
		int sum = 0;
		while (true) {
			sum += index++;
			if (sum >= X) {
				sum -= index--;
				X -= sum;
				break;
			}
		}
		X--;
//		System.out.println(index+" "+X);
		int right = 0;
		int left = 0;
		if (index % 2 == 0) {
			right = index;
			left = 1;
			right -= (X - 1);
			left += (X - 1);
		} else {
			left = index;
			right = 1;
			right += (X - 1);
			left -= (X - 1);
		}
		System.out.println(left + "/" + right);
	}

}
