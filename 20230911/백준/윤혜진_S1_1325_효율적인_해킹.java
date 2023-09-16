import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max;
	static ArrayList<Integer>[] map;
	static int[] dp;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N+1];
		dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[b].add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			v = new boolean[N+1];
			bfs(i);
		}
		
		for(int i = 1; i <= N; i++) {
			if(dp[i] == max)
				sb.append(i+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		v[start] = true;

		int cnt = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next: map[cur]) {
				if(v[next]) continue;
				cnt++;
				v[next] = true;
				q.add(next);
			}
		}
		max = Math.max(max, cnt);
		dp[start] = cnt;
	}

}
