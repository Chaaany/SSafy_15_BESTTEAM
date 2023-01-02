import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			int cur = nums[i];
			
			int left = 0;
			int right = N-1;
			while(left < right) {
				if(left == i) {
					left++;
					continue;
				}
				else if(right == i) {
					right--;
					continue;
				}
				
				int sum = nums[left]+nums[right];
				if(sum == cur) {
					count++;
					break;
				}
				else if(sum > cur) 
					right--;
				else if(sum < cur)
					left++;
			}
		}
		
		System.out.println(count);
	}

}
