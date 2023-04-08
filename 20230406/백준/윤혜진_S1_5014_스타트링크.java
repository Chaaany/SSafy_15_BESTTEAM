import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int F, S, G, U, D;
	static int[] stairs;
	static boolean[] v;
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		stairs = new int[F+1];
		v = new boolean[F+1];
		
		bfs();
		System.out.println(!check?"use the stairs":stairs[G]);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		v[S] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == G)  {
				check = true;
				return;
			}
			
			if(cur+U <= F && !v[cur+U]) {
				stairs[cur+U] = stairs[cur]+1;
				v[cur+U] = true;
				q.add(cur+U);
			}
			if(cur-D > 0 && !v[cur-D]) {
				stairs[cur-D] = stairs[cur]+1;
				v[cur-D] = true;
				q.add(cur-D);
			}
		}
		
	}

}
