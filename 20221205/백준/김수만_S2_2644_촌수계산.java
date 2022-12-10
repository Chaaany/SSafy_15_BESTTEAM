import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, a, b, m;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		ArrayList<Integer> adj[] = new ArrayList[n+1];
		for(int i=1; i<=n; i++)
			adj[i] = new ArrayList<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x].add(y);
			adj[y].add(x);
		}
		
		int ans = -1;
		Queue<int[]> q = new LinkedList<>();
		boolean v[] = new boolean[n+1];
		q.add(new int[] {a, 0});
		v[a] = true;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int x = cur[0], cnt = cur[1];
			if(x == b) {
				ans = cnt;
				break;
			}
			
			for(int next : adj[x]) {
				if(v[next]) continue;
				v[next] = true;
				q.add(new int[] {next, cnt+1});
			}
		}
		System.out.println(ans);
	}

}
