import java.io.*;
import java.util.*;

public class BJ_3184_양 {

	static int N,M, final_sheep, final_wolves;
	static char[][] map;
	static boolean[][] v;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		v = new boolean[N][M];
		
		final_sheep = 0;
		final_wolves = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='o') final_sheep++;
				else if(map[i][j]=='v') final_wolves++;
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!='#' && !v[i][j]) {
					bfs(i,j);
				}
			}
		}
		System.out.println(final_sheep+" "+final_wolves);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> qu = new LinkedList<int[]>();
		
		qu.add(new int[] {r,c});
		v[r][c] = true;
		
		int sheep = 0;
		int wolves = 0;
		
		if(map[r][c]=='o') {
			sheep++;
		}else if(map[r][c]=='v') {
			wolves++;
		}
		
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr>=0 && nc >=0 && nr< N && nc<M && !v[nr][nc] && map[nr][nc]!='#') {
					if(map[nr][nc]=='o') {
						sheep++;
					}else if(map[nr][nc]=='v') {
						wolves++;
					}
					qu.add(new int[] {nr,nc});
					v[nr][nc] = true;
				}
			}
		}
		
		if(sheep>wolves) {
			final_wolves -= wolves;
		}else {
			final_sheep -= sheep;
		}
	}
	
}
