import java.io.*;
import java.util.*;

public class BJ_2234_성곽 {

	
	static int N,M, room_cnt, room_max, room_total_max;
	static int[][] map, count;
	static boolean[][] v;
	static int[] dr = {0,-1,0,1};
	static int[] dc = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		count = new int[N][M];
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		room_cnt = 0;
		room_max = 0;
		room_total_max = 0;
		
		// 각 방마다 크기
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!v[i][j]) {
					int x = bfs(i,j);
					room_cnt++;
					list.add(x);
				}
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr<N && nc<M && nr >=0 && nc>=0) {
						if(count[r][c]!=count[nr][nc]) {
							room_total_max = Math.max(room_total_max, list.get(count[r][c]) + list.get(count[nr][nc]));
						}
					}
				}
			}
		}
		System.out.println(room_cnt);
		System.out.println(room_max);
		System.out.println(room_total_max);
	}

	private static int bfs(int r, int c) {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] {r,c});
		v[r][c] = true;
		count[r][c] = room_cnt;
		
		// 방 크기
		int cnt = 1;
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				// 벽있으면 pass
				if((map[cur[0]][cur[1]] & 1<<d)!=0) continue;
				
				if(nr<N && nc<M && nr>=0 && nc>=0) {
					if(v[nr][nc]) continue;
					v[nr][nc] = true;
					count[nr][nc] = room_cnt;
					
					cnt++;
					
					qu.add(new int[] {nr,nc});
				} 
			}
		}
		room_max = Math.max(room_max, cnt);
		return cnt;
	}

}
