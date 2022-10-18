import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int R, C;
	static char[][] map;
	static int gx, gy;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		int sx = -1, sy = -1;
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					sx = i;
					sy = j;
				} else if(map[i][j] == 'D') {
					gx = i;
					gy = j;
				}
			}
		}
		
		int ans = 0, turn = -1;
		Queue<int[]> q = new LinkedList<>();
		boolean v[][] = new boolean[R][C];
		q.add(new int[] {sx, sy, 0});
		v[sx][sy] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1], cnt = cur[2];
			
			if(x == gx && y == gy) {
				ans = cnt;
				break;
			}
			
			if(turn < cnt) {
				turn = cnt;
				waterSpread();
			}
			
			for(int d=0; d<4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C || v[nx][ny]) continue;
				if(map[nx][ny] == '*' || map[nx][ny] == 'X') continue;
				v[nx][ny] = true;
				q.add(new int[] {nx, ny, cnt+1});
			}
		}
		
		System.out.println(ans == 0 ? "KAKTUS" : ans);
	}
	
	// 물 확장
	static void waterSpread() {
		boolean v[][] = new boolean[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == '*') {
					for(int d=0; d<4; d++) {
						int nx = i + dx[d], ny = j + dy[d];
						if(nx < 0 || nx >= R || ny < 0 || ny >= C ||
								map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;
						v[nx][ny] = true;
					}
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(v[i][j]) map[i][j] = '*';
			}
		}
	}
}
