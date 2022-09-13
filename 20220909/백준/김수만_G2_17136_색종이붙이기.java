import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//색종이 붙이기
public class Main {

	private static int count[] = new int[] {0,5,5,5,5,5};
	private static int grid[][] = new int[10][10];
	private static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<10; i++) {
			String input[] = br.readLine().split(" ");
			for(int j=0; j<10; j++) {
				grid[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		dfs(0,0,0);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	//dfs + backtracking
	//(0,0)에서 시작해서 (9,9)까지 감
	private static void dfs(int x, int y, int cnt) {
		//끝 점에 도달했을 때 answer 갱신
		if(x >= 9 && y > 9) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		//pruning
		if(answer <= cnt) return;
		
		//아래 줄로 이동
		if(y > 9) {
			dfs(x+1, 0, cnt);
			return;
		}
		
		if(grid[x][y] == 1) {
			//큰 색종이부터 먼저 붙여봄
			for(int i=5; i>=1; i--) {
				if(count[i] > 0 && check(x,y,i)) {
					attach(x, y, i, 0);
					count[i]--;
					dfs(x, y+1, cnt+1);
					attach(x, y, i, 1);
					count[i]++;
				}
			}
		} else {
			dfs(x, y+1, cnt);
		}
	}
	
	//색종이를 붙이거나 떼는 함수
	private static void attach(int x, int y, int size, int val) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				grid[i][j] = val;
			}
		}
	}
	
	//색종이를 붙일 수 있는지 확인하는 함수
	private static boolean check(int x, int y, int size) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(i >= 10  || j >= 10 || grid[i][j] != 1) 
					return false;
			}
		}
		return true;
	}
}
