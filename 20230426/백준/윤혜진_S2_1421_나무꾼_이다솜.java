import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] wood = new int[N];

		int max = 0;
		for (int i = 0; i < N; i++) {
			wood[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, wood[i]);
		}
		
		long maxCost = 0;
		for (int i = 1; i <= max; i++) {
			long cost = 0;
			for (int j = 0; j < N; j++) {
				int cur = wood[j];
				if(cur < i) continue;
				
				long money = 0;
				if(cur%i == 0) money = (cur/i * i * W)-((cur/i-1)*C);
				else money = (cur/i * i * W)-((cur/i)*C);
				
				if(money > 0)
					cost += money;
			}
			maxCost = Math.max(maxCost, cost);
		}
		
		System.out.println(maxCost);
	}

}
