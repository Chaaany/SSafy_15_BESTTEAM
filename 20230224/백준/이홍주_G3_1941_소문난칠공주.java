import java.io.*;
import java.util.*;

public class BJ_1941_소문난칠공주 {

	static long answer;
	static char[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] arr;
	static boolean[][] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		arr = new int[7];
		v = new boolean[5][5];
		
		// 7개를 먼저 고른다
		combi(0,0);
		
		System.out.println(answer);
	}
	private static void combi(int cnt, int start) {
		if(cnt==7) {
			// bfs 방문 배열
			boolean[][] nv = new boolean[5][5];
			// 고른 7개가 서로 인접한지 확인
			bfsCheck(nv);
			return;
		}
		for (int i = start; i < 25; i++) {
			arr[cnt] = i;
			v[i/5][i%5] = true;
			combi(cnt+1, i+1);
			v[i/5][i%5] = false;
		}
	}
	private static void bfsCheck(boolean[][] nv) {
		Queue<int[]> qu = new LinkedList<>();
		
		int s_cnt = 0;
		int total = 0;
		
		qu.add(new int[] {arr[0]/5, arr[0]%5});
		nv[arr[0]/5][arr[0]%5] = true;
		
		while(!qu.isEmpty()) {
			int[] now = qu.poll();
			
			if(map[now[0]][now[1]] == 'S') s_cnt++;
			total++;
			
			for (int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d]; 
				int nc = now[1] + dc[d]; 
				
				if(nr<0 || nc<0 || nr>=5 || nc>=5) continue;
				if(!v[nr][nc] || nv[nr][nc]) continue;
				
				nv[nr][nc] = true;
				qu.add(new int[] {nr, nc});
			}
			
		}
		
		if(s_cnt>=4 && total==7) answer++;
	}

}
