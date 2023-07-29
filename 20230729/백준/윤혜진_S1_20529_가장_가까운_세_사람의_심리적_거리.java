import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			String[] mbti = new String[N];
			for (int i = 0; i < N; i++) {
				mbti[i] = st.nextToken();
			}
			
			int min = Integer.MAX_VALUE;
			loop:
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {					
					for (int k = j+1; k < N; k++) {
						int sum = count(mbti[i], mbti[j]) + count(mbti[i], mbti[k]) + count(mbti[j],mbti[k]);					
						min = Math.min(min, sum);
						if(min == 0) break loop;
					}
				}
			}
			
			sb.append(min+"\n");
		}
		
		System.out.println(sb);
	}

	private static int count(String s1, String s2) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			if(s1.charAt(i) != s2.charAt(i)) cnt++;
		}
		return cnt;
	}

}
