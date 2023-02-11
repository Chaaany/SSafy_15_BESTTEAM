import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Long T = Long.parseLong(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		HashMap<Long, Long> subA = new HashMap<>();
		HashMap<Long, Long> subB = new HashMap<>();
		
		for (int i = 1; i <= n; i++) {
			Long sum = (long)0;
			for (int j = i; j <= n; j++) {
				sum += (long)A[j];
				subA.put(sum, subA.getOrDefault(sum, (long)0)+1);
			}
		}
		for (int i = 1; i <= m; i++) {
			Long sum = (long)0;
			for (int j = i; j <= m; j++) {
				sum += (long)B[j];
				subB.put(sum, subB.getOrDefault(sum, (long)0)+1);
			}
		}
		
		long count = 0;
		for(Long a : subA.keySet()) {
			if(subB.containsKey(T - a)) {
				count += subA.get(a) * subB.get(T - a);
			}
		}
		
		System.out.println(count);
	}

}
