import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = 0;
		HashMap<String, Integer> hash = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			hash.put(line, hash.getOrDefault(line, 0)+1);
		}
		
		K = Integer.parseInt(br.readLine());
		
		int max = 0;
		for(String s : hash.keySet()) {
			int zero = 0;
			for (int i = 0; i < M; i++) {
				if(s.charAt(i) == '0') zero++;
			}
			
			if(zero > K || K%2 != zero%2) continue;
			max = Math.max(max, hash.get(s));
		}

		System.out.println(max);
	}

}
