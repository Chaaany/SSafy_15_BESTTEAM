import java.io.*;
import java.util.*;

public class BJ_22233_가희와키워드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new  HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(),",");
			
			while(st.hasMoreTokens()) {
				String now = st.nextToken();
				if(set.contains(now)) set.remove(now);
			}
			sb.append(set.size()+"\n");
		}
		
		System.out.print(sb.toString());
	}
	
}
