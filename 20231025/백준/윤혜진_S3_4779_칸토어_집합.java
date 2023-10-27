import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = "";
		while((line = br.readLine()) != null) {
			sb = new StringBuilder();
			int n = Integer.parseInt(line);
			int nn = (int) Math.pow(3, n);
			
			for (int i = 0; i < nn; i++) {
				sb.append("-");
			}
			
			go(0, nn);
			System.out.println(sb);
		}

	}

	private static void go(int start, int len) {
		if(len == 1) return;
		
		for (int i = start+len/3; i < start+(len/3*2); i++) {
			sb.setCharAt(i, ' ');
		}
		
		go(start, len/3);
		go(start+(len/3*2), len/3);
	}

}
