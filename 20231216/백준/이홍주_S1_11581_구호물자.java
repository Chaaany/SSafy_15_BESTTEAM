import java.io.*;
import java.util.*;

public class BJ_11581_구호물자 {

	static int N;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] v;
	static boolean answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new  ArrayList<>();
		v = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			list.add(new  ArrayList<>());
		}
		
		for (int i = 1; i <= N-1; i++) {
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
			
		}
		answer = true;
		v[1] = true;
		dfs(1);
		System.out.println(answer?"NO CYCLE":"CYCLE");
	}

	private static void dfs(int i) {
		if(!answer) return;
		for(Integer now : list.get(i)) {
			if(v[now]) {
				answer = false;
				return;
			}
			v[now] = true;
			dfs(now);
			v[now] = false;
		}
	}


}
