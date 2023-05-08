import java.io.*;
import java.util.*;

public class BJ_11501_주식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] jusik = new int[N];
			int[] max_number = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				jusik[i] = Integer.parseInt(st.nextToken());
			}
			// 뒤에서부터 최댓값 갱신
			int max = 0;
			for (int i = N-1; i >= 0; i--) {
				max_number[i] = max = Math.max(max, jusik[i]);
			}
			
			long buy_money = 0;
			long buy_count = 0;
			long answer = 0;
			
			// 앞에서부터 가장 높을 때 산거 다 팔고 그 뒤도 똑같이
			for (int i = 0; i < N; i++) {
				// 지금이 적기일때(최댓값일 때)
				if(jusik[i] == max_number[i]) {
					answer += (buy_count*jusik[i]) - buy_money;
					buy_count = 0;
					buy_money = 0;
				}else {
					buy_money += jusik[i];
					buy_count++;
				}
			}
						
			sb.append(answer+"\n");
		}
		System.out.print(sb.toString());
	}
}
