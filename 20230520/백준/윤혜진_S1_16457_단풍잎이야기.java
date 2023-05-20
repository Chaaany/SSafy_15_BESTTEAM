import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k;
	static int[] choice;
	static boolean[] v;
	static int[][] skill;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		choice = new int[n];
		v = new boolean[2*n+1];
		skill = new int[2*n+1][k];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int[] s = new int[k];
			for (int j = 0; j < k; j++) {
				int a = Integer.parseInt(st.nextToken());
				s[j] = a;
			}
			skill[i] = s;
		}
		
		comb(1,0);
		System.out.println(max);
	}

	private static void comb(int start, int cnt) {
		if(cnt == n) {
			ArrayList<Integer> arr = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				arr.add(choice[i]);
			}
			
			int count = 0;
			for (int i = 0; i < m; i++) {
				boolean check = true;
				for (int j = 0; j < k; j++) {
					if(!arr.contains(skill[i][j])) check = false;
				}
				if(check) count++;
			}
			max = Math.max(max, count);
			return;
		}
		for (int i = start; i < 2*n+1; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			choice[cnt] = i;
			comb(i+1, cnt+1);
			v[i] = false;
		}
	}

}
