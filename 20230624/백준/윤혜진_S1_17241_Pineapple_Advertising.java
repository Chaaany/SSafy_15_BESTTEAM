import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		boolean[] v = new boolean[N+1];
		boolean[] first = new boolean[N+1];
		
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for (int i = 0; i < Q; i++) {
			int count = 0;
			int n = Integer.parseInt(br.readLine());
			
			if(!v[n]) count++;
			v[n] = true;
			
			if(!first[n]) {
				first[n] = true;
				for (int j = 0; j < arr[n].size(); j++) {
					int near = arr[n].get(j);
					if(!v[near]) count++;
					v[near] = true;
				}
			}
			
			sb.append(count+"\n");
		}
		
		System.out.println(sb);
	}

}
