import java.io.*;
import java.util.*;

public class BJ_16457_단풍잎이야기 {

	static int[][] skill;
	static HashSet<Integer> set;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		skill = new int[m][k];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				skill[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		set = new HashSet<>();
		answer = 0;
		combi(n,0,0);
		System.out.println(answer);
	}
	private static void combi(int n, int start, int cnt) {
		if(cnt==n) {
			int count = 0;
			for (int i = 0; i < skill.length; i++) {
				boolean check = true;
				for (int j = 0; j < skill[0].length; j++) {
					if(!set.contains(skill[i][j])){
						check = false;
						break;
					}
				}
				if(check) count++;
			}
			answer = Math.max(answer, count);
			return;
		}
		
		for (int i = start; i <= 2*n; i++) {
			set.add(i);
			combi(n,i+1,cnt+1);
			set.remove(i);
		}
	}
	
}
