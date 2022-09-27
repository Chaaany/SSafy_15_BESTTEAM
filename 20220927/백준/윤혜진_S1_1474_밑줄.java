import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int len = 0;
		String[] list = new String[N];
		boolean[] upper = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			list[i] = line;
			len += line.length();
			if(line.charAt(0) <= 'Z')
				upper[i] = true;
			else if (line.charAt(0) >= 'a')
				upper[i] = false;
		}
				
		int count = M - len;
		int equal = count/(N-1);
		int remains = count%(N-1);
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < equal; j++) {
				list[i] = '_' + list[i];
			}
		}			

		if(remains > 0) {
			for (int i = 1; i < N; i++) {
				if(!upper[i] && remains > 0) {
					list[i] = '_' + list[i];
					remains--;
				}
			}
			
			if(remains > 0) {
				for (int i = N-1; i > 0; i--) {
					if(upper[i] && remains > 0) {
						list[i] = '_' + list[i];
						remains--;
					}
				}
			}
		}
				
		for (int i = 0; i < N; i++) {
			System.out.print(list[i]);
		}
		
	}

}
