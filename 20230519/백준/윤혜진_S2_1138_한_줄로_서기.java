import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[N+1];
		int[] result = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			memo[i] = Integer.parseInt(st.nextToken());
		}
		
		result[memo[1]+1] = 1;
		for (int i = 2; i < N+1; i++) {
			int tall = memo[i];
			int cnt = 0;
			for (int j = 1; j < N+1; j++) {
				if(cnt == tall && result[j] == 0) {
					result[j] = i;
					break;
				}
				if(result[j] == 0 || result[j] > i) cnt++;
			}
		}
		
		for(int i = 1; i < N+1; i++) sb.append(result[i]+" ");
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
