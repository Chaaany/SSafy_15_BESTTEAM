import java.io.*;
import java.util.*;

public class Main {

	static int N,M,max;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				boolean[][] v = new boolean[N][M];
				v[i][j] = true;
				dfs(i,j,v,1,0,map[i][j]);
			}
		}
		
		System.out.println(max);
	}
	private static void dfs(int r, int c, boolean[][] v, int now, int dir, int count) {
		if(now==2) {
			count += map[r][c];
		}
		if(now==3) {
			max = Math.max(max,count);
			// ㄴ자가 겹쳐진 모양 예외처리
      /*
      3 3
      1 1 1
      1 99 1
      1 1 1
      */
			dfs(r-dr[dir],c-dc[dir],v,0,0, count);
			now = 0;
		}
		for (int d = 0; d < 4; d++) {
			if(now==2 && d == dir) continue;
  			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nc <0 || nr>=N || nc>=M || v[nr][nc]) continue;
			v[nr][nc] = true;			
			dfs(nr,nc,v,now+1,d, count + map[nr][nc]);
			v[nr][nc] = false;
		}
	}
	
}
