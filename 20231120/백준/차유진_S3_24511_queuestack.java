import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_S3_24511_queuestack {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		StringTokenizer stz = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(stz.nextToken()); // i번째 원소의 값이 0이면 i번째 자료구조는 큐, 1이면 스택
		}
		stz = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(stz.nextToken()); // Bi 는 i번 자료구조에 들어있는 원소
		}
		int M = Integer.parseInt(br.readLine());
		int[] C = new int[M];
		stz = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			C[i] = Integer.parseInt(stz.nextToken()); // Ci는 i번 자료구조에 삽입할 원소
		}
		
		int cnt = 0;
		int idx1 = N-1;
		int idx2 = 0;
		while(true) {
			if(cnt == M) break;
			if(idx1 >= 0) {
				while(true) {
					if(A[idx1] == 0) {
						sb.append(Integer.toString(B[idx1--])+" ");
						break;
					} else {
						idx1--;
					}
					if(idx1 < 0) {
						sb.append(Integer.toString(C[idx2++])+" ");
						break;
					}
				}
			} else {
				sb.append(Integer.toString(C[idx2++])+" ");
			}
			cnt++;
		}
		String ans = sb.substring(0, sb.length() -1);
		System.out.println(ans);
		
	}

}
