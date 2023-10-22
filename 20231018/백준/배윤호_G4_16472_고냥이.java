import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int start = 0;
		int end = 0;
		int count = 0; // 알파벳 종류
		int max = 0;
		int[] alpha = new int[26];
		while (end < s.length()) {
			if (alpha[s.charAt(end) - 'a'] == 0) {
				count++;
			}
			alpha[s.charAt(end) - 'a']++;

			while (count > N) {
				if (alpha[s.charAt(start) - 'a'] == 1) {
					count--;
				}
				alpha[s.charAt(start) - 'a']--;
				start++;
			}
			max = Math.max(max, end - start + 1);
			end++;
		}
		System.out.println(max);
	}

}
