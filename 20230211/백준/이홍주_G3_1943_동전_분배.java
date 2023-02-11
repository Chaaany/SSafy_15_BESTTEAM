import java.io.*;
import java.util.*;

public class BJ_1943_동전분배 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		final int number = 50000;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < 3; t++) {
			int N = Integer.parseInt(br.readLine());
		
			int total = 0;
			int[] m = new int[N+1];
			int[] c = new int[N+1];
			// 만들 수 있나 없나 여부
			boolean[]dp = new boolean [number+1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				m[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
				total += m[i]*c[i];
				
				// 0은 사용 안함
				for (int k = 1; k <= c[i]; k++) {
					if(m[i]*k > number) break;
					dp[m[i]*k] = true;
				}
			}
			
			// 가진 동전으로 total/2 만들수있으면 가능(짝수일때만)			
			if(total%2==1) {
				sb.append(0+"\n");
				continue;
			}
			
			// 로직 안돌려도 될 때(굉장한 시간 단축 가능)
			if(dp[total/2]) {
				sb.append(1+"\n");
				continue;
			}
			
			for (int i = 1; i <= N; i++) {
				// ** 큰 수 부터 해야 중복 사용 피할 수 있음
				for (int j = total/2; j >= m[i]; j--) {
					// m[i]를 한번 더할 때 가능해야 그다음도 고려 가능
					if(!dp[j-m[i]]) continue;
					for (int k = 2; k <= c[i]; k++) {
						// 답은 무조건 total/2보다 적게 나옴
						if(j-m[i] + m[i]*k > total/2) break;
						dp[j-m[i] + m[i]*k] = true;
					}
				}
			}
			
			sb.append((dp[total/2]?1:0)+"\n");
		}
		System.out.print(sb.toString());
	}
}
