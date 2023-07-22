import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int P = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] acc = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			acc[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(acc);
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(P < 200) {
				P += acc[i];
				cnt++;
			}
			else break;
		}
		
		System.out.println(cnt);
	}

}
