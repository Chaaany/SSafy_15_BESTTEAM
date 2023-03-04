import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static char[][] map = new char[5][5];
	static boolean[][] select = new boolean[5][5];
	static int count;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int sCnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			String line = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		combi(0, 0, 0);
		
		System.out.println(count);
	}

	private static void combi(int cnt, int start, int sCnt) {		
		if(cnt==7) {
			if(check(sCnt)) count++;
			return;
		}

		for (int i = start; i < 25; i++) {
			int r = i/5;
			int c = i%5;
			if(!select[r][c]) {
				select[r][c] = true;
				
				if(map[r][c]=='S') combi(cnt+1, i+1, sCnt+1);
				else combi(cnt+1, i+1, sCnt);
				
				select[r][c] = false;
			}
		}
	}
	
	private static boolean check(int som) {
		if(som<4) return false;
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[5][5];
		
		loop:
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(select[i][j]) {
					q.add(new int[] {i, j});
					v[i][j] = true;
					break loop;
				}
			}
		}
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];

				if (!(nr>=0 && nc>=0 && nr<5 && nc<5) || !select[nr][nc] || v[nr][nc]) continue;
				
				cnt++;
				v[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
		
		return cnt==7?true:false;
	}		

}
