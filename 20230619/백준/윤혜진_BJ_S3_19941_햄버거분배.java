import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[] table = new char[N];
		
		String line = br.readLine();
		for (int i = 0; i < N; i++) {
			table[i] = line.charAt(i);
		}

		int count = 0;
		boolean[] v = new boolean[N];
		
		loop:
		for (int i = 0; i < N; i++) {
			if(table[i] == 'P') {
				for (int j = K; j > 0; j--) {
					if(!(i-j >= 0 && i-j < N)) continue;
					
					if(table[i-j] == 'H' && !v[i-j]) {
						count++;
						v[i-j] = true;
						continue loop;
					}
				}
				for (int j = 1; j <= K; j++) {
					if(!(i+j >= 0 && i+j < N)) continue;
					
					if(table[i+j] == 'H' && !v[i+j]) {
						count++;
						v[i+j] = true;
						continue loop;
					}
				}
			}
		}
		
		System.out.println(count);
	}

}
