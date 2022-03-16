import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int p[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		p = new int[N+1];
		init();
		for(int i=0; i<N-2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		int res = -1;
		for(int i=1; i<=N; i++) {
			if(find(i) != 1) {
				res = i;
				break;
			}
		}
		System.out.println("1"+" "+res);
	}
	
	private static void init() {
		for(int i=1; i<=N; i++)
			p[i] = i;
	}
	
	private static int find(int x) {
		if(x == p[x]) return x;
		return p[x] = find(p[x]);
	}

	//union조건: 작은 쪽으로 합치기
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return;
		
		if(rootA < rootB)
			p[rootB] = rootA;
		else
			p[rootA] = rootB;
	}
}
