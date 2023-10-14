import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] alpha = new int[26];
	static int len;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		len = S.length();
		
		for (int i = 0; i < len; i++) {
			alpha[S.charAt(i)-'a']++;
		}
		
		combi(0, "", ' ');
		System.out.println(count);
	}

	private static void combi(int cnt, String newS, char prev) {
		if(cnt == len) {
			count++;
			return;
		}
		for (int i = 0; i < 26; i++) {
			if(alpha[i]>0 && prev != (char)(i+'a')) {
				alpha[i]--;
				newS += (char)(i+'a');
				combi(cnt+1, newS, (char)(i+'a'));
				alpha[i]++;
			}
		}
	}

}
