import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean adj[][];
	static int cur;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new boolean[N+1][N+1];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int val = Integer.parseInt(st.nextToken());
				if(val == 0) adj[i][j] = false;
				else adj[i][j] = true;
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			if(i == 0) {
				cur = Integer.parseInt(st.nextToken());
				continue;
			}
			int goal = Integer.parseInt(st.nextToken());
			if(!bfs(goal)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	static boolean bfs(int goal) {
		Queue<Integer> q = new LinkedList<>();
		boolean v[] = new boolean[N+1];
		q.add(cur);
		v[cur] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == goal) {
				cur = now;
				return true;
			}
			
			for(int i=1; i<=N; i++) {
				if(v[i]) continue;
				if(adj[now][i]) {
					q.add(i);
					v[i] = true;
				}
			}
		}
		
		return false;
	}
}
