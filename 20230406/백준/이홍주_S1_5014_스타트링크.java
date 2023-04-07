import java.io.*;
import java.util.*;

public class BJ_5014_스타트링크 {

	static int F,S,G,U,D, answer;
	static boolean finish;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken()); // 층
		S = Integer.parseInt(st.nextToken()); // 시작
		G = Integer.parseInt(st.nextToken()); // 끝
		U = Integer.parseInt(st.nextToken()); // 위
		D = Integer.parseInt(st.nextToken()); // 아래
		
		finish = false;
		answer = Integer.MAX_VALUE;
		v = new boolean[F+1];
		
		dfs(S, 0);
		
		System.out.println(finish?answer:"use the stairs");
	}
	private static void dfs(int now, int cnt) {
		if(v[now] || answer < cnt) return;		
		v[now] = true;

		if(now==G) {
			finish = true;
			answer = Math.min(answer, cnt);
			return;		
		}
		
		if(now<G) {
			if(now+U>F && now-D >= 1) dfs(now-D, cnt+1);
			else if(now+U<=F) dfs(now+U, cnt+1);
		}else {
			if(now-D<1 && now+U <=F)  dfs(now+U, cnt+1);
			else if(now-D>=1) dfs(now-D, cnt+1);
		}
	}

}
