import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r,c;
	static int[] dr = {-1,0,1,0};
	static int[] dc = { 0,1,0,-1};
	static char[][] map;
	static List<int[]> list = new ArrayList<>();
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='L') {
					list.add(new int[] {i,j});
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			int[] start = list.get(i);
			int sr = start[0];
			int sc = start[1];
			bfs(sr,sc);
		}
		System.out.println(max);
	}
	private static void bfs(int sr, int sc) {
//		System.out.println(sr+" "+sc);
		boolean[][] v = new boolean[r][c];
		int count = 0;
		Queue<int[]> que = new LinkedList<>();
		v[sr][sc] = true;
		que.add(new int[] {sr,sc});
		while(!que.isEmpty()) {
			int size = que.size();
			count++;
			for (int i = 0; i < size; i++) {
				int[] cur = que.poll();
				int cr = cur[0];
				int cc = cur[1];
				for (int d = 0; d < 4; d++) {
					int nr = cr+dr[d];
					int nc = cc+dc[d];
					if(nr>=0 && nr<r && nc>=0 && nc<c && v[nr][nc]==false && map[nr][nc]=='L') {
						v[nr][nc] = true;
						que.add(new int[] {nr,nc});
					}
				}
			}
		}	
//		System.out.println(count-1);
		max = Math.max(count-1, max);
	}

}
