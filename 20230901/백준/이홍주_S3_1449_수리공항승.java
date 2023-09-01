import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class BJ_1449_수리공항승 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int answer = 0;
		double last = 0;
		
		
		for (int i = 0; i < N; i++) {
			if(arr[i] >= last) {
				last = arr[i] - 0.5 + L;
				answer++;
			}
		}
		
		System.out.println(answer);
	}


}
