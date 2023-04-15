import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		int count = 0;
		int len = 0;
		for (int i = 0; i < M-2;) {
			if(s.charAt(i) == 'O') {
				i++;
				continue;
			}
      
			if(s.charAt(i+1) == 'O' && s.charAt(i+2) == 'I') {
				len++;
				if(len == N) {
					count++;
					len--;
				}
				i += 2;
			}
			else {
				len = 0;
				i++;
			}
		}
		
		System.out.println(count);
	}

}
