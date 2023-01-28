import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		boolean[] prime = new boolean[N+1];
		ArrayList<Integer> arr = new ArrayList<>();
		
		Arrays.fill(prime, true);

		for (int i = 2; i <= N; i++) {
			if(!prime[i]) continue;
			
			for (int j = i+i; j <= N; j+=i) {
				prime[j] = false; // 소수 아님 처리
			}
		}
		
		for (int i = 2; i <= N; i++) {
			if(prime[i]) arr.add(i);
		}
		
		int sum = 2;
		int count = 0;
		int left = 0;
		int right = 0;
		while(left<arr.size() && right<arr.size()) {
			if(sum == N) {
				count++;
				sum -= arr.get(left);
				left++;
			}
			else if(sum < N) {
				right++;
				if(right < arr.size())
					sum += arr.get(right);
			}
			else if(sum > N) {
				left++;
				sum = arr.get(left);
				right = left;
			}
		}
		
		System.out.println(count);
	}

}
