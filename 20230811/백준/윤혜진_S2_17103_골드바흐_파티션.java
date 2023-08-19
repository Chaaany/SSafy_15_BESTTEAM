import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] prime = new boolean[1000001];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		for (int i = 2; i < 1000001; i++) {
			if(!prime[i]) continue;
			for (int j = i+i; j < 1000001; j+=i) {
				prime[j] = false;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			for (int i = 2; i <= N/2; i++) {
				if(prime[i] && prime[N-i]) count++;
			}
			sb.append(count+"\n");
		}

		System.out.println(sb);
	}

}
