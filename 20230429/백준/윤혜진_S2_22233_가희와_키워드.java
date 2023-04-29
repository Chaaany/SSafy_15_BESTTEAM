import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Mai {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> hash = new HashMap<>();
		for (int i = 0; i < N; i++) {
			hash.put(br.readLine(), 1);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			while(st.hasMoreTokens()) {
				String write = st.nextToken();
				if(hash.containsKey(write)) {
					hash.remove(write);
				}
			}
			sb.append(hash.size()+"\n");
		}
		
		System.out.println(sb);
	}

}
