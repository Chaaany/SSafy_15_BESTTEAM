import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int countA = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a') countA++;
		}

		str += str;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < str.length()-countA; i++) {
			String sub = str.substring(i, i+countA);
			int count = 0;
			for (int j = 0; j < sub.length(); j++) {
				if(sub.charAt(j) == 'b') count++;
			}
			min = Math.min(min, count);
		}
		 
		System.out.println(min);
	}

}
