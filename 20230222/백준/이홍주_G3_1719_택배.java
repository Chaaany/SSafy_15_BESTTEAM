import java.io.*;
import java.util.*;

public class BJ_1719_택배 {

	// Floyd
	static final int INF = 9999999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][N+1];
		int[][] answer = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i!=j) arr[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			 st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = c;
			answer[a][b] = b;
			answer[b][a] = a; 
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(i==k) continue;
				for (int j = 1; j <= N; j++) {
					if(k==j || i==j) continue;
					if(arr[i][j] > arr[i][k]+arr[k][j]) {
						arr[i][j] = arr[i][k]+arr[k][j];
						// 중간지점 check
						answer[i][j] = k;					
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i==j) sb.append("- ");
				else sb.append(dfs(answer,i,j,answer[i][j])+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	private static int dfs(int[][] answer, int i, int j, int k) {
		// 최초 방문 지점
		if(j == k) return k;
		k = dfs(answer, i, k, answer[i][k]);
		return k;
	}

}
