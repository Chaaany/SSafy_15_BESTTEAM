import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class BJ_14466_소가길을건너간이유6 {

	
	static int N,K,R, answer;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map, cow;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		cow = new int[N][N];
		
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken())-1;
			int c1 = Integer.parseInt(st.nextToken())-1;
			int r2 = Integer.parseInt(st.nextToken())-1;
			int c2 = Integer.parseInt(st.nextToken())-1;
			
			if(r1==r2) {
				if(c1>c2) {
					map[r1][c1] += 1<<3;
					map[r2][c2] += 1<<1;
				}else {
					map[r1][c1] += 1<<1;
					map[r2][c2] += 1<<3;
				}
			}else if(c1==c2) {
				if(r1>r2) {
					map[r1][c1] += 1<<0;
					map[r2][c2] += 1<<2;
				}else {
					map[r1][c1] += 1<<2;
					map[r2][c2] += 1<<0;
				}
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			cow[r][c] = 1;
		}
		
		answer = 0;
		// bfs
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(cow[i][j]==1) {
					cow[i][j] = 0;
					bfs(i,j);
				}
			}
		}
		
		System.out.println(answer);
		
	}

	private static void bfs(int i, int j) {
		Queue<int[]> qu = new LinkedList<int[]>();
		boolean[][] v = new boolean[N][N];
		qu.add(new int[] {i,j});
		v[i][j] = true;
		int cnt = 0; // 만나는 소의 수
		
		
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			
			if(cow[cur[0]][cur[1]]==1) cnt++;
			
			for (int d = 0; d < 4; d++) {
				// 상하좌우 벽 체크
				if((map[cur[0]][cur[1]] & 1 << d ) > 0) continue;
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr>=0 && nc>=0 && nr<N && nc<N && !v[nr][nc]) {
					qu.add(new int[] {nr,nc});
					v[nr][nc] = true;
				}
			}
		}
		
		answer += (K-1)-cnt;
		K--;
	}


}
