import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, max;
	static int[] hp, happy;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		hp = new int[N];
		happy = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hp[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			v = new boolean[N];
			dfs(0,0,i,100,0);
		}
		
		System.out.println(max);
	}

	private static void dfs(int start, int cnt, int choice, int totalHp, int totalHappy) {
		if(cnt == choice) {
			if(totalHp > 0) {
				max = Math.max(max, totalHappy);
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			dfs(i+1, cnt+1, choice, totalHp-hp[i], totalHappy+happy[i]);
			v[i] = false;
		}
	}

}
