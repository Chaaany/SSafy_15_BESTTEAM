import java.io.*;
import java.util.*;

public class 이홍주_G5_2589_보물섬 {

	static int R,C,max;
	static char[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			char[] arr = br.readLine().trim().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = arr[j];
			}
		}
		
		max = -1;
		
		for (int i = 0; i < R; i++) {			
			for (int j = 0; j < C; j++) {
				if(map[i][j]=='L') {
					bfs(i,j);
				}
			}
		}		
		System.out.println(max);
	}

	private static void bfs(int sr, int sc) {
		Queue<int[]> qu = new LinkedList<>();
		boolean[][] v = new boolean[R][C];
		v[sr][sc] = true;
		
		qu.add(new int[] {sr,sc,0});
		
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr>=R || nc>=C || nr<0 || nc<0 || v[nr][nc]) continue;
				if(map[nr][nc]=='L') {
					v[nr][nc] = true;
					max = Math.max(cur[2]+1, max);
					qu.add(new int[] {nr,nc,cur[2]+1});
				}
			}
		}
	}
}
