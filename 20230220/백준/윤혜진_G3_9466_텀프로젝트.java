import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, count;
	static int[] map;
	static boolean[] v, team;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			count = 0;
			n = Integer.parseInt(br.readLine());
			map = new int[n+1];
			v = new boolean[n+1];
			team = new boolean[n+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= n; i++) {
				dfs(i);
			}
			
			sb.append((n-count)+"\n");
		}
		
		System.out.println(sb);
	}

	private static void dfs(int x) {
		if(team[x]) return;
		
		if(v[x]) {
			count++;
			team[x] = true;
		}
		
		else v[x] = true;
		
		int next = map[x];
		dfs(next);
	
		v[x] = false;
		team[x] = true;
	}

}
