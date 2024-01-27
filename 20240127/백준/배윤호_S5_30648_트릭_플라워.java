import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(br.readLine());
		boolean[][] v = new boolean[R][R];
		int sec = 0;
		v[a][b] = true;
		while (true) {
			sec++;
			if (a + b + 2 >= R) {
				a /= 2;
				b /= 2;
			} else {
				a++;
				b++;
			}
			if (v[a][b]) {
				break;
			}
			v[a][b] = true;
		}
		System.out.println(sec);
	}

}
