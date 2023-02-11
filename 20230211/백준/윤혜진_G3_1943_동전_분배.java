import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < 3; t++) {
			int N = Integer.parseInt(br.readLine());
			
      HashMap<Integer, Integer> coin = new HashMap<>();
			int[] dp = new int[100001];
			dp[0] = 1;
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				sum += a*b;
				coin.put(a, b);
			}
			
			if(sum%2 == 1) {
				sb.append("0\n");
				continue;
			}
			
			for (int key : coin.keySet()) {
				int value = coin.get(key);
				for (int i = 50000; i >= key; i--) {
					if (dp[i-key] == 1) {
						for (int j = 0; j < value; j++) {
              if(i+(key*j) >=0)
                  dp[i + (key*j)] = 1;							
						}
					}
				}
			}
			
			sb.append(dp[sum/2]+"\n");
		}
		
		System.out.println(sb);
	}

}
