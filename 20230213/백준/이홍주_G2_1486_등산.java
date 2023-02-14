import java.io.*;
import java.util.*;

public class BJ_1486_등산 {

	static final int  INF = 9999999;
	static int N,M,T,D,total, answer;
	static int[][] map,Floyd;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1, 0,-1};
	static int[] height;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		total = N*M;
		height = new int[total+1];
		map = new int[N+1][M+1];
		Floyd = new int[total+1][total+1];
		
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine().trim();
			for (int j = 1; j <= M; j++) {
				char cs = str.charAt(j-1);
				if(cs>='A' && cs<='Z') map[i][j] = cs-'A';
				else  map[i][j] = cs-'a'+26;
				
				height[(i-1)*M + j] =  map[i][j];
			}
		}
		
		for (int i = 0; i <= total; i++) {
			for (int j = 0; j <= total; j++) {
				// *********************************꼭 i!=j가 다를때만 INF 초기화
				if(i!=j) Floyd[i][j] = INF;
			}
		}
		
		// 인접행렬로 변환
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr>=1 && nc>=1 && nr<= N && nc<= M) {
						int s = map[r][c];
						int e = map[nr][nc];
						int sr = M*(r-1) + c;
						int se = M*(nr-1) + nc;
						int diff = Math.abs(s-e);
						
						if(diff<=T) {
							if(s>=e) Floyd[sr][se] = 1;	
							else Floyd[sr][se] = diff*diff;						
						}
					}
					
				}
			}
		}
		
		// 플와 (출->도 + 도->출) 최소시간 두개를 더한게  D이하일때  max값 도출		
		for (int k = 1; k <= total; k++) {
			for (int i = 1; i <= total; i++) {
				if(i==k) continue;
				for (int j = 1; j <= total; j++) {
					if(i==j || k==j) continue;
					if(Floyd[i][j] > Floyd[i][k]+ Floyd[k][j]) Floyd[i][j] = Floyd[i][k] + Floyd[k][j];
				}
			}
		}
		
		// 최대 높이
		answer = map[0][0];
		for (int k = 1; k <= total; k++) {
			if(Floyd[1][k]+Floyd[k][1] <=D ) answer =  Math.max(answer, height[k]);
		}
		
		System.out.println(answer);
	}
}
