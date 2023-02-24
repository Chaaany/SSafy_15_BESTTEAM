import java.io.*;
import java.util.*;

public class BJ_9466_텀프로젝트 {

	static int T, N, count;
	static int[] students;
	static boolean[] already, v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			students = new int[N+1];
			// 방문 끝났는지
			already = new boolean[N+1];
			// 사이클 판별 방문배열
			v = new boolean[N+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				students[i] = Integer.parseInt(st.nextToken());
			}
			
			count = 0;
			
			for (int i = 1; i <= N; i++) {
				if(!v[i])  dfs(i);
			}
			
			sb.append((N-count)+"\n");
		}
		System.out.print(sb.toString());
	}

	private static void dfs(int idx) {
		v[idx] = true;
		
		int next = students[idx];
		
		if(!v[next]) dfs(next);
		else if(!already[next]) {
			// 사이클 탐지 시 한 그룹의 개수 세기
			while(true) {
				// 본인 count 먼저
				count++;
				if(next==idx) break;
				next = students[next];
			}
		}
		// 더이상 방문 x
		already[idx] = true;
	}

}
