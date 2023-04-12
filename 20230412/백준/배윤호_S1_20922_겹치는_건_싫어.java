import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int[] count = new int[100001];
		int left = 0;
		int right = 0;
		while (right < N) {
			while (count[nums[right]] + 1 <= K) {
				count[nums[right]]++;
				right++;
				if (right == N)
					break;
			}
			int leng = right - left;
			max = Math.max(max, leng);
			count[nums[left]]--;
			left++;
		}
		System.out.println(max);
	}

}
