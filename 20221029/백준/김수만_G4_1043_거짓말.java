import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static Set<Integer> party[]; // 파티에 누가 있었는지
	static Set<Integer> person[]; // 그 사람이 어떤 파티에 있었는지
	static boolean know[]; // 누가 진실을 아는지
	static boolean v[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		party = new HashSet[M];
		person = new HashSet[N+1];
		know = new boolean[N+1];
		v = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		for(int i=0; i<K; i++) {
			int num = Integer.parseInt(st.nextToken());
			know[num] = true;
		}
		for(int i=1; i<=N; i++)
			person[i] = new HashSet<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			party[i] = new HashSet<>();
			for(int j=0; j<K; j++) {
				int val = Integer.parseInt(st.nextToken());
				party[i].add(val);
				person[val].add(i);
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(know[i]) dfs(i);
		}
		
		ArrayList<Integer> list = new ArrayList<>(); // 진실을 말해야 하는 파티 목록
		for(int i=0; i<M; i++) {
			for(int p : party[i]) {
				if(know[p]) {
					list.add(i);
					break;
				}
			}
		}
		System.out.println(M-list.size());
	}

	static void dfs(int p) {
		for(int i : person[p]) {
			for(int j : party[i]) {
				if(v[j]) continue;
				v[j] = true;
				know[j] = true;
				dfs(j);
			}
		}
	}
}
