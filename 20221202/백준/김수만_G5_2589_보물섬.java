import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N, M;
	static char[][] map;
	static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++)
				map[i][j] = input.charAt(j);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'W') continue;
				bfs(i, j);
			}
		}
		System.out.println(ans);
	}

	static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		boolean v[][] = new boolean[N][M];
		q.add(new int[] {a, b, 0});
		v[a][b] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1], cnt = cur[2];
			ans = Math.max(ans, cnt);
			
			for(int d=0; d<4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || v[nx][ny] || map[nx][ny] == 'W') continue;
				v[nx][ny] = true;
				q.offer(new int[] {nx, ny, cnt+1});
			}
		}
	}
}
