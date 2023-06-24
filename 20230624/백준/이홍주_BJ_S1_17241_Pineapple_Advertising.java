import java.io.*;
import java.util.*;

public class BJ_17241_Pineapple_Advertising {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		boolean[] v = new boolean[N+1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int x = Integer.parseInt(br.readLine());
			int tmp = 0;
			
			if(!v[x]) {
				tmp++;
				v[x] = true;
			}
			
			for (int j = list.get(x).size()-1; j >= 0; j--) {
				if(!v[list.get(x).get(j)]) {
					tmp++;
					v[list.get(x).get(j)] = true;
          // 지워줘야 시간초과 안남 (중복 제공이 가능하기 떄문..)
					list.get(x).remove(j);
				}
			}
			
			sb.append(tmp+"\n");
		}
		System.out.print(sb.toString());
	}	
	
	
}
