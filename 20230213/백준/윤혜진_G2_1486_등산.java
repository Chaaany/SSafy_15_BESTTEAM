import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = line.charAt(j);
				if(c <= 90) {
					map[i][j] = c-65;  // 'A' : 65
				}
				else
					map[i][j] = c-71;  // 'a' : 97 
			}
		}
		
		int[][] dist = new int[N*M][N*M];
		
		for (int i = 0; i < N*M; i++) {
			for (int j = 0; j < N*M; j++) {
				if(i==j) continue;
				dist[i][j] = 987654321;
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(!(nr>=0 && nc>=0 && nr<N && nc<M)) continue;
					int height = Math.abs(map[r][c]-map[nr][nc]);
					if(height <= T) {
						// 내려가는길
						if(map[r][c] >= map[nr][nc]) {
							dist[r*M+c][nr*M+nc] = 1;
						}
						else {
							dist[r*M+c][nr*M+nc] = (height) * (height);
						}
					}
				}
			}
		}
		
		for (int k = 0; k < N*M; k++) {
			for (int i = 0; i < N*M; i++) {
				if(k==i) continue;
				for (int j = 0; j < N*M; j++) {
					if(j==i) continue;
					if(dist[i][j] > dist[i][k]+dist[k][j])
						dist[i][j] = dist[i][k]+dist[k][j];
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int idx = i*M+j;
				if(dist[0][idx]+dist[idx][0] <= D)
					max = Math.max(max, map[i][j]);
			}
		}
		
		System.out.println(max);

	}

}
