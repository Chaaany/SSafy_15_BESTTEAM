import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class BJ_23559_밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		
		long[] arr = new long[N]; // 차이
		long now = 0; // 여태까지 쓴돈
		long answer = 0; // 답
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());		
			int A = Integer.parseInt(st.nextToken()); //5000
			int B = Integer.parseInt(st.nextToken()); //1000
			
			now += 1000;
			answer += B;
			arr[i] = A-B;
		}
		
		Arrays.sort(arr);
		
		for (int i = N-1; i >= 0; i--) {
			if(now + 4000 <= X && arr[i] > 0) {
				answer += arr[i];
				now += 4000;
			}
		}
	
		
		System.out.println(answer);
	}


}
