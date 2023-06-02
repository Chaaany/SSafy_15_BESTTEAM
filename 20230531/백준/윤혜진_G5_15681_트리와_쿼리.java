import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, R, Q;
	static int[] level;
	static int[] memo;
	static boolean[] v;
	static ArrayList<Integer>[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		level = new int[N+1];
		memo = new int[N+1];
		v = new boolean[N+1];
		arr = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		dfsLevel(R, 1);
		
		for (int i = 0; i < Q; i++) {
			int query = Integer.parseInt(br.readLine());
			Arrays.fill(v, false);
			int result = dfs(query);
			sb.append(result+"\n");
		}
		
		System.out.println(sb);
	}

	private static void dfsLevel(int x, int l) {
		if (level[x] != 0) return;

		level[x] = l;
		for (int next : arr[x]) {
			if (next != R)
				dfsLevel(next, l+1);
		}
	}

	private static int dfs(int x) {
		if(memo[x] != 0) return memo[x];
		
		v[x] = true;
		int cnt = 1;
		for (int next : arr[x]) {
			if (level[x] < level[next] && !v[next]) {
				cnt += dfs(next);
			}
		}
		
		memo[x] = cnt;
		return memo[x];
	}

}
