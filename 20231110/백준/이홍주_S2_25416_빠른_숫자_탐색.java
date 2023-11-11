import java.io.*;
import java.util.*;

public class BJ_25416_빠른숫자탐색 {

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		int[][] map = new int[5][5];
		boolean[][] v=  new boolean[5][5];
		
		
		for (int i = 0; i < 5; i++) {
			st = new  StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		st = new  StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] {sr,sc,0});
		v[sr][sc] = true;
		
		int answer = -1;
		
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			
			if(map[cur[0]][cur[1]] == 1) {
				answer = cur[2];
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr>=0 && nc>=0 && nr<5 && nc<5 && map[cur[0]][cur[1]]!=-1) {
					if(v[nr][nc]) continue;
					qu.add(new int[] {nr,nc,cur[2]+1});
					v[nr][nc] = true;
				}
			}
		}
		
		
		System.out.println(answer);
	}


}
