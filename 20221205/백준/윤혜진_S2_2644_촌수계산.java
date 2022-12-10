import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, a, b, m;
	static int[][] map;
	static boolean[] v;
	static int count = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		v = new boolean[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		dfs(a, 0);
		System.out.println(count);

	}

	private static void dfs(int t, int cnt) {
		if(t == b) {
			count = cnt;
			return;
		}
		for (int i = 1; i < n+1; i++) {
			if(map[t][i] == 1 && !v[i]) {
				v[i] = true;
				dfs(i, cnt+1);
			}
		}
	}

}
