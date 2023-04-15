import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(N==1) {
			System.out.println(1);
			return;
		}
		
		int[] cnt = new int[100001];
		int len = 0;
		int left = 0;
		int right = 0;
		
		while(left <= right && right < N) {
			if(cnt[arr[right]] < K) {
				cnt[arr[right]]++;
				right++;
			}
			else {
				cnt[arr[left]]--;
				left++;
			}
			len = Math.max(len, right-left);	
		}
		
		System.out.println(len);
	}

}
