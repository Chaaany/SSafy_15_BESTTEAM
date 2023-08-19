import java.io.*;
import java.util.*;

public class BJ_1535_안녕 {

	static int N, answer;
	static int[] strength, joy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		strength = new int[N];
		joy = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			strength[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			joy[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = 0;
		dfs(0,0,100,0);
		System.out.println(answer);
	}

	private static void dfs(int cnt, int start, int now_stren, int now_joy) {
		if(now_stren==0) {
			return;
		}
		
		if(cnt==N) {
			answer = Math.max(answer, now_joy);
			return;
		}
		
		for (int i = start; i < N; i++) {
			if(now_stren-strength[i] >= 0) {
				dfs(cnt+1, i+1, now_stren-strength[i], now_joy + joy[i]);				
			}
		}
		answer = Math.max(answer, now_joy);
	}


}
