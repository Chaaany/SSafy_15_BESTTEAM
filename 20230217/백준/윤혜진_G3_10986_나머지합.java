import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] nums = new long[N+1];
		long[] remain = new long[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = (nums[i-1] + Integer.parseInt(st.nextToken())) % M;
			remain[(int)nums[i]]++;
		}

		long count = remain[0];
		for (int i = 0; i < M; i++) {
			if(remain[i] >= 2) {
				long n = remain[i];
				count += n*(n-1)/2;
			}
		}
		
		System.out.println(count);
	}

}
