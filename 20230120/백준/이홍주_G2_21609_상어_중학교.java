import java.io.*;
import java.util.*;

public class BJ_21609_상어중학교 {

	static int N,M;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map;
	static PriorityQueue<Block> pq;
	public static class Block implements Comparable<Block>{
		int r;
		int c;
		int size;
		int rainbow;
		public Block(int r, int c, int size, int rainbow) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.rainbow = rainbow;
		}
		
		@Override
		public int compareTo(Block o) {
			if(this.size==o.size) {
				if(this.rainbow==o.rainbow) {
					// 여러개라면 열이 가장 큰 것
					if(this.r==o.r) return o.c - this.c;
					// 여러개라면 기준 블록의 행이 가장 큰 것
					else return o.r - this.r;
				}else {
					// 여러개라면 무지개블록 수 많은 블록 그룹
					return o.rainbow-this.rainbow;
				}
			}else {
				return o.size-this.size;
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pq = new PriorityQueue<>();
		long answer = 0;
		while(true) {
			
			//무지개 블록 제외 방문 배열 저장
			boolean[][] v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 기준 블록은 무지개 아닌 것중 행의 번호 작->열 작
					if(!v[i][j] && map[i][j] > 0) findBlockGroup(v,i,j,map[i][j]);
				}
			}
			
			// pq의 사이즈가 0이라면 break
			if(pq.size()==0) break;
			
			// 찾은 모든 블록 제거 + B^2 더한다
			answer += Bomb(pq.poll());
			// 중력
			Gravity();
			// 90도 반시계방향 회전
			Rotate();
			// 중력
			Gravity();
			pq.clear();
		}
		System.out.println(answer);
	}
	
	private static void Rotate() {
		int[][] arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = map[j][N-1-i];
			}
		}
		map = arr.clone();
	}
	private static void Gravity() {
		for (int r = N-2; r >= 0; r--) {
			for (int c = 0; c < N; c++) {
				// 공중에 떠있는 블록
				if(map[r][c] >= 0) {
					int nr = r+1;
					while(nr < N) {						
						// 다른 블록 만나거나 맨 아래가 공백이면 switch
						if(map[nr][c]!=-2 || (map[nr][c] == -2 && nr==N-1) ) {
							if(map[nr][c]==-2) change(r,c,nr,c);
							else  change(r,c,nr-1,c);
							break;
						}
						// 빈공간이면 계속 탐색
						++nr;
					}
				}
			}
		}
	}
	private static void change(int r1, int c1, int r2, int c2) {
		int tmp = map[r1][c1];
		map[r1][c1] = map[r2][c2];
		map[r2][c2] = tmp;
	}
	private static long Bomb(Block block) {
		Queue<int[]> qu = new LinkedList<int[]>();
		boolean[][] tmp = new boolean[N][N];
		int number  = map[block.r][block.c];
		
		qu.add(new int[] {block.r,block.c});
		tmp[block.r][block.c] = true;
		
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			// 빈공간 만들기
			map[cur[0]][cur[1]] = -2;
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				if(cango(nr,nc) && !tmp[nr][nc] && (map[nr][nc] == number || map[nr][nc] == 0)) {
					qu.add(new int[] {nr,nc});
					tmp[nr][nc] = true;
				}			
			}
		}
		
		return (long) Math.pow(block.size, 2);
	}
	private static void findBlockGroup(boolean[][] v, int r, int c, int number) {
				
		Queue<int[]> qu = new LinkedList<int[]>();
		boolean[][] tmp = new boolean[N][N];
		// 기준 블록의 위치
		qu.add(new int[] {r,c});
		tmp[r][c] = true;
		// 무지개블록 size
		int rainbow = 0;
		int size = 1;
		
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				if(cango(nr,nc) && !v[nr][nc] && !tmp[nr][nc] && (map[nr][nc] == number || map[nr][nc] == 0)) {
					qu.add(new int[] {nr,nc});
					tmp[nr][nc] = true;
					size++;
					
					if(map[nr][nc] == 0) rainbow++;
					// 무지개 블록은 방문배열 재활용 가능
					else v[nr][nc] = true;
				}			
			}
		}
		// bfs로 크키 큰 블록 그룹 찾은 후 pq에 각각 삽입
		if(size>=2) pq.add(new Block(r,c,size,rainbow));
	}
	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}

}
