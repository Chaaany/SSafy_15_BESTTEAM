import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		String[] enter = new String[N];
		String[] out = new String[N];
		
		for (int i = 0; i < N; i++) {
			enter[i] = br.readLine();
		}
		
		for (int i = 0; i < N; i++) {
			out[i] = br.readLine();
		}
		
		int count = 0;
		boolean[] v = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!enter[i].equals(out[j])) {
					if(!v[j]) {
						v[j] = true;
						count++;
					}
				}
				else {
					v[j] = true;
					break;	
				}
			}
		}
		
		System.out.println(count);
	}

}
