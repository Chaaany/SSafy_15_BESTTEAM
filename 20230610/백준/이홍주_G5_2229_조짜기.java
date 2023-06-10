import java.io.*;
import java.util.*;

public class BJ_2229_조짜기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());		
		int[] students = new int[N+1];
		int[] dp = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < students.length; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < students.length; i++) {
			int min = students[i];
			int max = students[i];
			dp[i]  = dp[i-1];
			
			for (int j = i-1; j > 0; j--) {
				min = Math.min(min, students[j]);
				max = Math.max(max, students[j]);
				
				dp[i] = Math.max(dp[i], dp[j-1] + max - min);
			}
		}
		System.out.println(dp[N]);
	}

}
