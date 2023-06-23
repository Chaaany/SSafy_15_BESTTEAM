import java.io.*;
import java.util.*;

public class BJ_16918_봄버맨 {

	static int R,C,N;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if(str.charAt(j)=='.') {
					map[i][j] = -1;
				}
			}
		}
		
		int time = 1;
		boolean check = true;
		while(time!=N) {		
			time++;
			if(check) {
				// 모든 폭탄 설치
				install(time);
				check = false;
			}else {
				// 3초전 폭탄 폭발 (상하좌우 같이 제거)
				bomb(time);
				check = true;
			}
		
		}
		
		StringBuilder sb = new StringBuilder();		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]==-1) sb.append('.');
				else sb.append('O');
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	private static void bomb(int time) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]==time-3) {
					map[i][j] = -1;
					for (int d = 0; d < 4; d++) {
						int r = i + dr[d];
						int c = j + dc[d];
						
						if(r>=0 && c>=0 && r<R && c<C && map[r][c]!=time-3) {
							map[r][c] = -1;
						}
					}
				}
			}
		}
	}
	
	private static void install(int time) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]==-1) map[i][j] = time;
			}
		}
	}

}
