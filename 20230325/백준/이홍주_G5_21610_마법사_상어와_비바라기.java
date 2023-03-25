import java.io.*;
import java.util.*;

public class BJ_21610_마법사상어와비바라기 {

	static int N,M;
	static int[][] map;
	static boolean[][] check;
	static int[] dr = {0,0,-1,-1,-1,0,1,1,1};
	static int[] dc = {0,-1,-1,0,1,1,1,0,-1};
	static Queue<int[]> moveList;
	static Queue<int[]> newMoveList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
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
		
		// 구름 이동 list
		moveList = new LinkedList<>();
		// 대각선 체크용 구름 위치 list
		newMoveList = new LinkedList<>();
		
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 2; j++) {
				moveList.add(new int[] {N-i,j});				
			}
		}
		int answer = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			check = new boolean[N+1][N+1];
			// 이동 후 비내림 => 사라짐
			move(d, s);
			
			// 물복사 (대각선 체크)
			copy();
			
			// 2이상 구름 생김
			answer = create();
		}
		
		// 바구니 들어있는 물의 양의 합
		System.out.println(answer);
	}

	private static int create() {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j]>=2 && !check[i][j]) {
					moveList.add(new int[] {i,j});
					map[i][j] -= 2;
				}
				// 마지막에 정답 체크
				sum += map[i][j];
			}
		}
		return sum;
	}

	private static void copy() {
		while(!newMoveList.isEmpty()) {
			int[] now = newMoveList.poll();
			int count = 0;
			for (int d = 2; d <= 8; d+=2) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				
				if(cango(nr,nc) && map[nr][nc] !=0) count++;
			}
			
			map[now[0]][now[1]] += count;
		}
	}

	private static void move(int d, int s) {
		while(!moveList.isEmpty()) {
			int[] now = moveList.poll();
			
			int nr = now[0] + (dr[d]*s)%N;
			int nc = now[1] + (dc[d]*s)%N;
			
			// (양수) N을 넘을 때는 (넘은 수 - N) 만큼 해야 1부터 다시 시작
			// (음수) N이하일 때는 (넘은 수 + N) 만큼 해야 N부터 다시 시작
			// nr = N - (1-nr) + 1 를 축약한 것
			
			if(nr>N) nr -= N;
			if(nr<1) nr += N;
			if(nc>N) nc -= N;
			if(nc<1) nc += N;
			
			map[nr][nc]++;
			newMoveList.add(new int[] {nr,nc});
			check[nr][nc] = true;
		}
	}

	private static boolean cango(int r, int c) {
		return r<=N && c<=N && r>=1 && c>=1;
	}

}
