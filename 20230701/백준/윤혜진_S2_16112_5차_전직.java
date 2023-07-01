import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[] map = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			map[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(map);
		
		long sum = 0;
		int count = 1;
		for (int i = 1; i < n; i++) {
			sum += map[i]*count;
			if(count < k) {
				count++;
			}
		}
		
		System.out.println(sum);
	}

}
