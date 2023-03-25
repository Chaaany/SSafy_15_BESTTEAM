import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 첫 구름
		q.add(new int[] {N, 1});
		q.add(new int[] {N, 2});
		q.add(new int[] {N-1, 1});
		q.add(new int[] {N-1, 2});
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			v = new boolean[N+1][N+1];
			move(d-1, s);
			copy();
			makecloud();
		}
		
		int count = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				count += map[i][j];
			}
		}
		
		System.out.println(count);
	}

	private static void move(int d, int s) {
		int size = q.size();
		for(int i = 0; i < size; i++) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];

			for(int j = 0; j < s; j++) {
				cr = cr + dr[d];
				cc = cc + dc[d];
				
				if(cr>N) cr = 1;
				if(cc>N) cc = 1;
				if(cr<1) cr = N;
				if(cc<1) cc = N;
			}
			
			q.add(new int[] {cr, cc});
			map[cr][cc]++;
			v[cr][cc] = true;
		}
	}

	private static void copy() {
		int size = q.size();
		for(int i = 0; i < size; i++) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			int cnt = 0;
			// 홀수가 대각선
			for(int d = 1; d < 8; d += 2) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>0 && nc>0 && nr<=N && nc<=N)) continue;
				if(map[nr][nc]>0) cnt++;  // 물이 있는 바구니만 카운트
			}
			
			map[cr][cc] += cnt;
		}
	}
	
	private static void makecloud() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 새로운 구름 생성
				if(!v[i][j] && map[i][j]>=2) {
					q.add(new int[] {i, j});
					map[i][j] -= 2;
				}
			}
		}
	}
}
