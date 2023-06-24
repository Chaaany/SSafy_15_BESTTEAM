import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, N, time;
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if(line.charAt(j) == '.') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		
		time = 1;
		while(true) {
			if(time == N) break;
			
			// 폭탄 설치
			time++;
			add();
			if(time == N) break;
			
			// 폭탄 폭발
			time++;
			boom();
			if(time == N) break;
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]==0?".":'O');
			}
			System.out.println();
		}
	}

	private static void add() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 0)
					map[i][j] = time;
			}
		}
	}

	private static void boom() {
		Queue<int[]> q = new LinkedList<>();
		
		// 터질 폭탄들 위치 저장
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] < time-1) {
					q.add(new int[] {i, j});
				}
			}
		}
		
		// 폭탄 폭발
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			map[cr][cc] = 0;
			
			for(int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<R && nc<C)) continue;
				map[nr][nc] = 0;
			}
		}
		
	}

}
