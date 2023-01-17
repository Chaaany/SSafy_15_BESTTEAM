import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];
		
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			int position = word.length()-1;
			
			for (int j = 0; j < word.length(); j++) {
				alpha[word.charAt(j)-65] += Math.pow(10, position--);
			}
		}
		
		Arrays.sort(alpha);
		
		int num = 9;
		int sum = 0;
		for (int i = 25; i >= 0; i--) {
			if(alpha[i] != 0) {
				sum += alpha[i] * num--;
			}
		}
		
		System.out.println(sum);

	}

}
