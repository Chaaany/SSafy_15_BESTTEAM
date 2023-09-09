import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] map = new ArrayList[N+1];
		boolean[] v = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}

		v[1] = true;
		for (int friend : map[1]) {
			v[friend] = true;

			for (int ffriend : map[friend]) {
				if (!v[ffriend]) {
					v[ffriend] = true;
				}
			}
		}
		
		int count = 0;
		for (int i = 2; i <= N; i++) {
			if(v[i]) count++;
		}
		
		System.out.println(count);
	}

}
