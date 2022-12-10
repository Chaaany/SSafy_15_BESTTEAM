import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		
		parent = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				int connect = Integer.parseInt(st.nextToken());
				
				if(connect == 1) {
					union(i, j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		
		int result = 0;
		int parent1 = find(a);
		for (int i = 1; i < M; i++) {
			int parent2 = find(Integer.parseInt(st.nextToken()));
			if(parent1 != parent2) {
				System.out.println("NO");
				result = 1;
				break;
			}
			parent1 = parent2;
		}
		
		if(result == 0) {
			System.out.println("YES");
		}
	}
	
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		
		return parent[x] =  find(parent[x]);
	}
	
	public static void union(int x, int y) {
		// 각각 루트노드 찾기
		x = find(x);
		y = find(y);
		
		if(x != y) {
			// y의 부모를 x의 부모로 치환
			if(x < y) {
				parent[y] = x;
			}
			else {
				parent[x] = y;
			}
		}
	}

}
