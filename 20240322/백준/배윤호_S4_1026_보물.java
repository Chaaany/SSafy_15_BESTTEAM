import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] n1 = new int[N];
		Integer[] n2 = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			n1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			n2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(n1);
		Arrays.sort(n2, Collections.reverseOrder());
		int s = 0;
		for (int i = 0; i < N; i++) {
			s += n1[i] * n2[i];
		}
		System.out.println(s);

	}

}
