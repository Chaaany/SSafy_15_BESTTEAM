import java.io.*;
import java.util.*;

public class BJ_25496_장신구명장임스 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int P = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if(P < 200) answer++;
			if(P+A[i] > 200) break;
			P += A[i];
		}
		System.out.println(answer);
	}

	
}
