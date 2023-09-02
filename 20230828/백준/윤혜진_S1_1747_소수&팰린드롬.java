import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 소수 판별 - 에라토스테네스의 체
		boolean[] prime = new boolean[2000001];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		for (int i = 2; i < 2000001; i++) {
			for (int j = i+i; j < 2000001 ; j+=i) {
				prime[j] = false;
			}
		}
		
		for (int i = N; i <= 2000001; i++) {
			if(prime[i] && isPal(i)) {
				System.out.println(i);
				break;
			}
		}

	}

	// 팰린드롬 판별
	private static boolean isPal(int n) {
		String s = Integer.toString(n);
		
		int left = 0;
		int right = s.length()-1;
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		
		return true;
	}

}
