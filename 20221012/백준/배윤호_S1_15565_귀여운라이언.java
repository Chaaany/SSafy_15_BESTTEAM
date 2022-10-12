import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] lionIndex = new int[N];
		Arrays.fill(lionIndex, Integer.MAX_VALUE);
		int lion = 0;
		int answer = 1000000;
		for (int i = 0; i < N; i++) {
			int doll = Integer.parseInt(st.nextToken());
			if(doll==1) {
				lionIndex[lion++] = i;
			}
		}
		for (int i = 0; i < lion-K+1; i++) {
			answer = Math.min(answer,lionIndex[i+K-1]-lionIndex[i]+1);
		}
		if(lion<K) {
			answer = -1;
		}
		System.out.println(answer);
	}
}
