import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		boolean[][]	map = new boolean[26][26];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = st.nextToken().charAt(0) - 'a';
			st.nextToken();
			int y = st.nextToken().charAt(0) - 'a';
			
			map[x][y] = true;
		}
		
		for (int k = 0; k < 26; k++) {
			for (int i = 0; i < 26; i++) {
				if(i == k) continue;
				for (int j = 0; j < 26; j++) {
					if(j == k) continue;
					if(map[i][k] && map[k][j]) map[i][j] = true;
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = st.nextToken().charAt(0) - 'a';
			st.nextToken();
			int y = st.nextToken().charAt(0) - 'a';

			sb.append(map[x][y]?"T":"F")
				.append("\n");
		}
		
		System.out.println(sb);
	}

}
