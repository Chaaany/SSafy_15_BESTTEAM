import java.io.*;
import java.util.*;

public class BJ_10986_나머지합 {

	// 누적합 + 아이디어 문제
	// sum(i,j)가 M으로 나누어 떨어지려면 sum[j]%M - sum[i-1]%M = 0 이면되고 sum[j]%M = sum[i]%M 이어야 함(즉 2개 이상)
	// 그러나 0인경우는 자기자신이 떨어지는 경우가 있기때문에 추가로 세주어야 함
	// 그 외에는 2이상이면 combination 공식 사용해서 개수 추가
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		long[] sum = new long[N+1];
		long[] cnt = new long[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = (sum[i-1]+arr[i])%M;
			cnt[(int)sum[i]]++;
		}
		
		// 자기혼자 나누어 떨어지는 경우 예외처리
		long answer = cnt[0];
		for (int i = 0; i < M; i++) {
			if(cnt[i]>=2) answer +=  (cnt[i] * (cnt[i]-1))/2;
		}
		
		System.out.println(answer);
	}

}
