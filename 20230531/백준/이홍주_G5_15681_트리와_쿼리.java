import java.io.*;
import java.util.*;

public class BJ_15681_트리와쿼리 {

	static int N,R,Q;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] v;
	static int[] size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점수
		R = Integer.parseInt(st.nextToken()); // 루트번호
		Q = Integer.parseInt(st.nextToken()); // 쿼리수
		list = new ArrayList<>(); // 간선정보
		v = new boolean[N+1]; // 노드 방문배열
		size = new int[N+1]; // 저장해둔 간선 수
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			list.get(U).add(V);
			list.get(V).add(U);
		}
		
		size[R] = makeTree(R);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int now = Integer.parseInt(br.readLine());
			sb.append(size[now]+"\n");
		}
		System.out.print(sb.toString());
	}

	private static int makeTree(int n) {
		if(size[n] != 0) return size[n];
		v[n]  = true;
		
		// 개수 count
		int cnt = 1;
		for (int i = 0; i < list.get(n).size(); i++) {
			int next = list.get(n).get(i);
			if(v[next]) continue;
			cnt += makeTree(next);
		}
		size[n] = cnt;
		return cnt;
	}
	
}
