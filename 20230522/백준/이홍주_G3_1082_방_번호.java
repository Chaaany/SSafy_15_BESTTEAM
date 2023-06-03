import java.io.*;
import java.util.*;

public class BJ_1082_방번호 {

	static int N;
	static int[] P, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		P  = new int[N];
		ans = new int[100];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		
		int cost = 0;
		int idx = 0;
		// M이하 중 개수 많고 큰숫자 많을 수록 best
		int minIdx = findMin(0);
		if(minIdx == 0) { // 0이 가장 싼값이라면
			minIdx = findMin(1);
			if(P[minIdx] <= M) { // 두번째 싼 숫자를 맨 앞으로
				ans[idx++] = minIdx;
				cost += P[minIdx];
				minIdx = 0;
			}else {
				System.out.println(0);
				return;
			}
		}
		while(cost + P[minIdx] <= M) {
			ans[idx++] = minIdx;
			cost += P[minIdx];
		}
		
		// 앞에서부터 큰숫자로 교체시도
		for (int i = 0; i < idx; i++) {
			for (int j = N-1; j >= 0; j--) {
				if(cost - P[ans[i]] + P[j] <= M) {
					cost = cost - P[ans[i]] + P[j];
					ans[i] = j;
					break;
				}
			}
		}
		for (int i = 0; i < idx; i++) {
			System.out.print(ans[i]);
		}
	}

	private static int findMin(int start) {
		int idx = 0;
		int min = Integer.MAX_VALUE;
		for (int i = start; i < N; i++) {
			if(min > P[i]) {
				min = P[i];
				idx = i;
			}
		}
		return idx;
	}
	

}
