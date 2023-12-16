import java.io.*;
import java.util.*;

public class BJ_17204_죽음의게임 {

	static int answer,N,K;
	static boolean[] v;
	static int[] num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		num = new int[N];
		v = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		answer = Integer.MAX_VALUE;
		
		dfs(0, 0);
		
		System.out.println(answer==Integer.MAX_VALUE?(-1):answer);
	}

	private static void dfs(int i, int cnt) {
		if(v[i]) return;
		v[i] = true;
		if(i==K) answer = Math.min(answer, cnt);
		dfs(num[i], cnt+1);
	}

}
