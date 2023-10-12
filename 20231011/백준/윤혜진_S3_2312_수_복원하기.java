import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] prime = new boolean[100001];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		for (int i = 2; i < 100001; i++) {
			if(!prime[i]) continue;
			for (int j = i+i; j < 100001; j+=i) {
				prime[j] = false;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] nums = new int[100001];
			
			while(N != 1) {
				for (int i = 2; i < 100001; i++) {
					if(!prime[i]) continue;
					if(N%i == 0) {
						N /= i;
						nums[i]++;
					}
				}
			}
			
			for (int i = 0; i < 100001; i++) {
				if(nums[i] != 0) {
					sb.append(i + " " + nums[i] + "\n");  
				}
			}
		}
		
		System.out.println(sb);
	}

}
