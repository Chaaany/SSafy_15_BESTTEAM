import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long[] arr = new long[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long min = Long.MAX_VALUE;
		int left = 0;
		int right = 0;
		while(right<N && left<=right) {
			long gap = arr[right]-arr[left];
			
			if(gap >= M) {
				min = Math.min(min, gap);
				left++;
			}
			else if(gap < M) right++;
		}
		
		System.out.println(min);
	}

}
