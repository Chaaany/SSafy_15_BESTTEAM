import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean check;
	static boolean[] v;
	static boolean[][] map;
	static ArrayList<Integer>[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][N];
		
		arr = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for (int i = 0; i < N; i++) {			
			v = new boolean[N];
			dfs(i,0);
		}
			
		System.out.println(check?1:0);
	}

	private static void dfs(int start, int depth) {
        if(check) return;
		if(depth == 5) {
			check = true;
			return;
		}
		for (int num : arr[start]) {
			if (v[num]) continue;
			v[num] = true;
			dfs(num, depth + 1);
			v[num] = false;
		}
		
	}

}
