import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static String s;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		int N = s.length();
		int[] dp = new int[N];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {				
				if(palindrome(j, i)) {
					if(j==0)
						dp[i] = 1;
					else 
						dp[i] = Math.min(dp[i], dp[j-1]+1);
				}
			}
		}
		
		System.out.println(dp[N-1]);
	}

	private static boolean palindrome(int start, int end) {
		int left = start;
		int right = end;

		while (left <= right) {
			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			} else
				return false;
		}
		
		return true;
	}

}
