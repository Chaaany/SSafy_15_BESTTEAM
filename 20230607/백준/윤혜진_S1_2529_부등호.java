import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int k;
	static String max, min;
	static char[] sign;
	static int[] choice;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());
		sign = new char[k];
		choice = new int[k+1];
		v = new boolean[10];
		max = "0";
		min = "9999999999";
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		
		perm(0);
		System.out.println(max+"\n"+min);
	}

	private static void perm(int cnt) {
		if(cnt == k+1) {
			// 부등호 조건 체크
			for (int i = 0; i < k; i++) {
				if(sign[i] == '<') {
					if(choice[i] > choice[i+1]) return;
				}
				else {
					if(choice[i] < choice[i+1]) return;
				}
			}
			
			// 최대, 최소 갱신
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < k+1; i++) {
				sb.append(choice[i]);
			}
			if(Long.parseLong(max) < Long.parseLong(sb.toString()))
				max = sb.toString();
			if(Long.parseLong(min) > Long.parseLong(sb.toString()))
				min = sb.toString();

			return;
		}
		for (int i = 0; i < 10; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			choice[cnt] = i;
			perm(cnt+1);
			v[i] = false;
		}
	}

}
