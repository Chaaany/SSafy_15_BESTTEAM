import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] v;
	static int min = Integer.MAX_VALUE;
	static int[] dr =  { 0, 1, 0, -1 };
	static int[] dc =  { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		v = new boolean[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		System.out.println(min);
	}

	private static void dfs(int cnt, int total) {
		if(cnt == 3) {
			min = Math.min(min, total);
			return;
		}
		for (int i = 2; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if(!v[i][j] && check(i,j)) {
					int cost = visit(i,j);
					dfs(cnt+1, total+cost);
					visitDelete(i,j);
				}
			}
		}
	}

	private static void visitDelete(int r, int c) {
		v[r][c] = false;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			v[nr][nc] = false;
		}
	}

	private static int visit(int r, int c) {
		int sum = map[r][c];
		v[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			v[nr][nc] = true;
			sum += map[nr][nc];
		}
		return sum;
	}

	private static boolean check(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(v[nr][nc]) return false;
		}
		return true;
	}

}
