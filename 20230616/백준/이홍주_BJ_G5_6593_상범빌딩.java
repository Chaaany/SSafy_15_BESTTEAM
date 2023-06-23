import java.io.*;
import java.util.*;

public class BJ_6593_상범빌딩 {

	static int L,R,C;
	static char[][][] map;
	static boolean[][][] v;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();		
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L==0 && R==0 && C==0) break;
			
			map = new char[L][R][C];
			v = new boolean[L][R][C];
			int sl = 0;
			int sr = 0;
			int sc = 0;
			
			
			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					String str = br.readLine();
					for (int c = 0; c < C; c++) {
						map[l][r][c] = str.charAt(c);
						if(map[l][r][c]=='S') {
							sl = l;
							sr = r;
							sc = c;
						}
					}
				}
				br.readLine();
			}
			
			
			boolean check = false;
			
			Queue<int[]> qu = new LinkedList<int[]>();
			qu.add(new int[] {sl,sr,sc, 0});
			v[sl][sr][sc] = true;
			
			int answer = 0;
			while(!qu.isEmpty()) {
				int[] cur = qu.poll();
				int l = cur[0];
				int r = cur[1];
				int c = cur[2];
				int time = cur[3];
				
				if(map[l][r][c]=='E') {
					answer = time;
					check = true;
					break;
				}
				
				// 상하좌우
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr>=0 && nc>=0 && nr<R && nc<C && !v[l][nr][nc] && map[l][nr][nc]!='#') {
						qu.add(new int[] {l,nr,nc, time+1});					
						v[l][nr][nc] = true;
					}
				}
				
				// 위아래
				if(l>0 && !v[l-1][r][c] && map[l-1][r][c]!='#') {
					qu.add(new int[] {l-1,r,c, time+1});					
					v[l-1][r][c] = true;					
				}
				
				if(l<L-1 && !v[l+1][r][c] && map[l+1][r][c]!='#') {
					qu.add(new int[] {l+1,r,c, time+1});					
					v[l+1][r][c] = true;									
				}
			}
			 
			if(check) sb.append("Escaped in ").append(answer).append(" minute(s).\n");
			else sb.append("Trapped!\n");
		}
		
		System.out.print(sb.toString());
	}	
	
}
