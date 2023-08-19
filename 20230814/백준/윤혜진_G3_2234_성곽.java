import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static String[][] map;
	static boolean[][] v;
	static int count, maxRoom, removeMax;
	static int[] dr = { 1, 0, -1, 0 };  // 하우상좌 - 이진수 순서
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[M][N];
		v = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				String s = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
				if(s.length() < 4) {
					while(s.length() != 4) {
						s = "0"+s;
					}
				}
				map[i][j] = s;
			}
		}
		
		// 방 개수, 최대 넓이
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!v[i][j]) {
					count++;
					int room = bfs(i, j);
					maxRoom = Math.max(maxRoom, room);
				}
			}
		}

		// 벽 제거
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				String cur = map[i][j];
								
				for (int d = 0; d < 4; d++) {
					char[] copy = cur.toCharArray();

					if(copy[d] == '1') {
						v = new boolean[M][N];
						copy[d] = '0';
						map[i][j] = String.valueOf(copy);
						int room = bfs(i,j);
						removeMax = Math.max(removeMax, room);
						map[i][j] = cur;
					}
				}
			}
		}
		
		System.out.println(count+"\n"+maxRoom+"\n"+removeMax);
	}

	private static int bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		v[i][j] = true;
		
		int room = 0;
		while(!q.isEmpty()) {
			room++;
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 4; d++) {
				if(map[cr][cc].charAt(d) == '1') continue;
				
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>= 0 && nr<M && nc<N) || v[nr][nc]) continue;
				
				q.add(new int[] {nr, nc});
				v[nr][nc] = true;
			}
		}
		
		return room;
	}

}
