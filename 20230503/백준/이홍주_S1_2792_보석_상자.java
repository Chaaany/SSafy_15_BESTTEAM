import java.io.*;
import java.util.*;

public class BJ_2792_보석상자 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 보석 수
		int[] jewels = new int[M];
		
		long max = 0;
		for (int i = 0; i < M; i++) {
			jewels[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, jewels[i]);
		}
		
		long s = 1;
		// 가장 많은 보석 수
		long e = max;
		long answer = Long.MAX_VALUE;
		
		while(s<=e) {
			long mid = (s+e)/2;
			
			// 보석 받는 학생의 수
			long sum = 0;
			for (int i = 0; i < jewels.length; i++) {
				sum += jewels[i]/mid;
				
				// 보석을 모두 나눠줘야 하기 때문
				if(jewels[i] % mid != 0) {
					sum++;
				}
			}
			
			// 모두 받거나 안받기
			if(sum <= N) {
				e = mid-1;
				// 질투심 최소 갱신
				answer = Math.min(answer, mid);
			}else {
				// 학생 수 초과
				s = mid+1;
			}
		}
		
		System.out.println(answer);
	}
	
}
