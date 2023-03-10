import java.io.*;
import java.util.*;

public class BJ_2110_공유기설치 {

	static int N, C;
	static long answer;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		// 범위 설정 조심! 거리를 잡았기 때문에 최소는 0 최대는 배열 양끝 차이값으로
		long start = 0;
		long end = arr[N-1] - arr[0];
		
		if(C>2) {
			answer = 0;
			while(start<=end) {
				
				// 최소거리
				long mid = (start + end)/2;
				
				int count = 1;
				int before_idx = 0;
				
				for(int i = 1; i < N; i++) {
					if(arr[i]-arr[before_idx]>=mid) {
						count++;
						before_idx = i;
					}
				}
				
				// 해당 최소 거리로 나올 수 있는 공유기 개수
				if(count >= C) {
					if(answer < mid) answer = mid;
					start = mid+1;
				}else {
					end = mid-1;
				}
				
			}
			
		}else {
			answer = end;			
		}		
		
		System.out.println(answer);
	}

}

/* 도움 받은 반례
4 2
11
13
16
18
 */
