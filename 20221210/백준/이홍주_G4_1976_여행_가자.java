import java.io.*;
import java.util.*;

public class BJ_1976_여행가자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		final int INF = 999999999;
		int[][] map = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int x =  Integer.parseInt(st.nextToken());
				if(x==0) map[i][j] = INF;
				else map[i][j] = 1;
				if(i==j) map[i][j] = 0;
			}
		}
		int[] plan = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(i==k) continue;
				for (int j = 1; j <= N; j++) {
					if(i==j || k==j) continue;
					if(map[i][j] > map[i][k]+map[k][j]) {
						map[i][j] = map[i][k]+map[k][j];
					}
				}
			}
		}
		

		int start = plan[0];
		boolean cango = true;
		for (int i = 1; i < M; i++) {
			if(map[start][plan[i]]==INF) {
				cango = false;
				System.out.println("NO");
				break;
			}
		}
		if(cango) System.out.println("YES");
	}

}
