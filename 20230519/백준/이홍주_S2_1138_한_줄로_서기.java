import java.io.*;
import java.util.*;

public class BJ_1138_한줄로서기 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] people = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for (int j = 1; j < people.length; j++) {
				if(people[j]==0 && cnt == num) {
					people[j] = i;
					break;
				}
				if(people[j]==0) {
					cnt++;
					continue;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < people.length; i++) {
			sb.append(people[i]+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

	
}
