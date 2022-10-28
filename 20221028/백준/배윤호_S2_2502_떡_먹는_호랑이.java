import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String[] day;

	public static void main(String[] args) throws IOException {
		day = new String[31];
		day[1] = "a";
		day[2] = "b";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int Dduk = Integer.parseInt(st.nextToken());
		for (int i = 3; i < D + 1; i++) {
			day[i] = day[i - 1] + day[i - 2];
		}
		int aCount = 0;
		int bCount = 0;
		for (int i = 0; i < day[D].length(); i++) {
			if (day[D].charAt(i) == 'a') {
				aCount++;
			} else {
				bCount++;
			}
		}
		int b = Dduk / bCount;
		int a = 1;

		while (true) {
			if (bCount * b + aCount * a == Dduk)
				break;
			if (bCount * b + aCount * a > Dduk) {
				b--;
			} else {
				a++;
			}
		}
		System.out.println(a);
		System.out.println(b);
	}

}
