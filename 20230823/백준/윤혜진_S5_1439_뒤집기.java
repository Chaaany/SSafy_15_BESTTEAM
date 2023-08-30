import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int cnt = 1;
		
		for (int i = 1; i < str.length(); i++) {
			if(str.charAt(i) != str.charAt(i-1)) 
				cnt++;
		}
		
		System.out.println(cnt/2);
	}

}
