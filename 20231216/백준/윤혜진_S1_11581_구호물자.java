import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		
		for (int i = 1; i < N; i++) {
			int cnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
		
			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][num] = 1;
			}
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][k]==1 && map[k][j]==1)
						map[i][j] = 1;
				}
			}
		}

		boolean cycle = false;
		for (int i = 1; i <= N; i++) {
			if(map[1][i]==1 && map[i][i]==1) {
				cycle = true;
				break;
			}
		}
		
		System.out.println(cycle?"CYCLE":"NO CYCLE");
	}

}
