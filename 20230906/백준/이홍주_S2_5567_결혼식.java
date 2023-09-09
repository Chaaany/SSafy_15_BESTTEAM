import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class BJ_5567_결혼식 {

	static int N, M, answer;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] v, v2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		v = new boolean[N+1];
		v2 = new boolean[N+1];
		
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
		
		answer = 0;		
		
		v[1] = true;
		v2[1] = true;
		
		for (Integer idx:list.get(1)) {
			if(!v[idx]) {
				v[idx] = true;
				answer++;
			}
		}
		
		for (int i = 2; i < v.length; i++) {
			if(v[i]) {
				for (Integer idx:list.get(i)) {
					if(!v2[idx] && !v[idx]) {
						v2[idx] = true;
						answer++;
					}
				}
			}
		}
		
		
		System.out.println(answer);
	}


}
