import java.io.*;
import java.util.*;

public class BJ_1261_알고스팟 {

	
	static int N, M;
	static int[][] map, num;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		num = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
				num[i][j] = Integer.MAX_VALUE;
			}
		}
		
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] {0,0,0});
		
		num[0][0] = 0;
		int answer = N*M;
		
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			
			if(cur[0]==N-1 && cur[1]==M-1) {
				answer = Math.min(answer, cur[2]);
				continue;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				
				// 부수기
				if(map[nr][nc]==1 && num[nr][nc] > cur[2]+1) {
					qu.add(new int[] {nr,nc,cur[2]+1});
					num[nr][nc] = cur[2]+1;
				}else if(map[nr][nc]==0 && num[nr][nc] > cur[2]){
					// 안부수기
					qu.add(new int[] {nr,nc,cur[2]});
					num[nr][nc] = cur[2];
				}
			}
		}
		
		System.out.println(answer);
	}
	
}
