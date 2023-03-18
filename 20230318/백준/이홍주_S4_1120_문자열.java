import java.io.*;
import java.util.*;

public class BJ_1120_문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < B.length(); i++) {
			int count = 0;
			boolean check = true;
			for (int j = 0; j < A.length(); j++) {
				if(i+j >= B.length()) {
					check = false;
					break;
				}
				if(A.charAt(j)!=B.charAt(i+j)) count++;
			}
			if(check) answer = Math.min(answer, count);
		}
		System.out.println(answer);
	}

}
