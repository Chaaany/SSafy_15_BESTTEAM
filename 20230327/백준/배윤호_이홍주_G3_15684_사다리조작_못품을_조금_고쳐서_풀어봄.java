import java.io.*;
import java.util.StringTokenizer;

public class BJ_15684_사다리조작 {

	static int N,M,H,answer;
	static int[][] sadari;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		sadari = new int[H+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sadari[a][b] = b+1;
			sadari[a][b+1] = b;
		}
		
		answer = 4;
		
		// 사다리 개수
		for (int i = 0; i <= 3; i++) {
			if(answer==4) combi(i, 0, 1);
		}
		
		System.out.println(answer>3?-1:answer);
	}
	
	private static void combi(int n, int cnt, int start) {
		if(n==cnt) {
//			System.out.println(n+" checks");
//			for (int i = 1; i < sadari.length; i++) {
//				for (int j = 1; j < sadari[0].length; j++) {
//					System.out.print(sadari[i][j]+" ");
//				}System.out.println();
//			}
//			System.out.println();
//			dfs(cnt,1,1,1);
			check(cnt);
			return;
		}
		
		for (int i = start; i <= H*N; i++) {
			int r = i/(N) + 1;
			int c = i%(N);
			if(c==0) {
				r--;
				c=N;
			}
			if(sadari[r][c]==0) {
				if(c < N && sadari[r][c+1]==0) {
					sadari[r][c] = c+1;
					sadari[r][c+1] = c;
					combi(n, cnt+1, i+1);
					sadari[r][c] = 0;
					sadari[r][c+1] = 0;
				}
				
				if(c > 1 && sadari[r][c-1]==0) {
					sadari[r][c] = c-1;
					sadari[r][c-1] = c;
					combi(n, cnt+1, i+1);
					sadari[r][c] = 0;
					sadari[r][c-1] = 0;
				}
			}
		}
	}
// 제대로 내려가는지 체크하는거 재귀 없는 함수로 만들어서 통과했습니다!
	private static void check(int cnt) {
		boolean v = true;
		for (int i = 1; i < N+1; i++) {
			int row = 1;
			int col = i;
			while(row<H+1) {
				if(sadari[row][col]!=0) {
					col = sadari[row][col];
				}
				row++;
			}
			if(col!=i) {
				v = false;
				break;
			}
		}
		if(v) {
			answer = Math.min(answer, cnt);
		}
		
	}
//재귀로 풀어 보려고했는데 안되네요... 밑에 else if문 넣어서 예제는 다 맞게 뜨는데 시간초과 났음 ㅠ
	private static void dfs(int cnt, int row, int col, int number) {
		if(cnt>3) return;

		boolean check = false;
		for (int i = row; i < sadari.length; i++) {
			if(!check && sadari[row][col]!=0) {
				check = true;
				dfs(cnt, i+1, sadari[row][col], number);
			}
			else if(!check && sadari[row][col]==0) {
				check = true;
				dfs(cnt, i+1, col, number);
			}
		}
		
		// 끝에 왔는데 
		if(!check) {
			// 자기자리로 왔다면
			if(col==number) {
				if(number==N) {
					answer = Math.min(answer, cnt);
					return;
				} else dfs(cnt, 1, number+1, number+1);
			}else return;
		}
	}
	
	
}
