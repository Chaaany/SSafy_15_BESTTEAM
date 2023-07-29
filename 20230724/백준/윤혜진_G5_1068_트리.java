import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] parent, child;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		parent = new int[N];  // 부모 누군지
		child = new int[N];  // 자식의 수
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			if(parent[i] == -1) continue;
			child[parent[i]]++;
		}
		
		int r = Integer.parseInt(br.readLine());
		if(parent[r] >= 0) child[parent[r]]--;
		dfs(r);
		
		int leaf = 0;
		for (int i = 0; i < N; i++) {
			if(child[i] == 0) leaf++;
		}
		
		System.out.println(leaf);
	}

	private static void dfs(int remove) {
		child[remove] = -1;
		for (int i = 0; i < N; i++) {
			if(parent[i]==remove) dfs(i);
		}
	}

}
