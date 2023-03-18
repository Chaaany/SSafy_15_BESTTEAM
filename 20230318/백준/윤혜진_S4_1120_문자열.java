import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();		
		int min = 987654321;

		for (int i = 0; i <= b.length()-a.length(); i++) {
			String str = b.substring(i, i+a.length());
			
			int cnt = 0;
			for (int j = 0; j < str.length(); j++) {
				if(a.charAt(j) != str.charAt(j)) cnt++;
			}
			min = Math.min(min, cnt);
		}
		
		System.out.println(min);
	}

}
