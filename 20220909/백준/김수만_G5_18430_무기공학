import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//무기 공학
public class Main {

	private static int dx[][] = {{-1,0}, {-1,0}, {1,0}, {1,0}};
	private static int dy[][] = {{0,1}, {0,-1}, {0,-1}, {0,1}};
	private static int answer = 0;
	private static int N, M;
	private static int material[][];
	private static boolean v[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		material = new int[N][M];
		v = new boolean[N][M];
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				material[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		backtracking(0,0,0);
		System.out.println(answer);
	}
	
	private static void backtracking(int x, int y, int val) {
		answer = Math.max(answer, val);
		for(int a = x>=1 ? x-1 : x; a<N; a++) {
			for(int b= y>=1 ? y-1 : y ; b<M; b++) {
				if(v[a][b]) continue;
				for(int i=0; i<4; i++) {
					int x1 = a + dx[i][0], x2 = a + dx[i][1];
					int y1 = b + dy[i][0], y2 = b + dy[i][1];
					if(x1 < 0 || x1 >= N || x2 < 0 || x2 >= N || y1 < 0 || y1 >= M || y2 < 0 || y2 >= M) continue;
					if(v[x1][y1] || v[x2][y2]) continue;
					v[a][b] = v[x1][y1] = v[x2][y2] = true;
					backtracking(a, b, val + material[a][b]*2 + material[x1][y1] + material[x2][y2]);
					v[a][b] = v[x1][y1] = v[x2][y2] = false;
				}
			}
		}
	}

}
