import java.io.*;
import java.util.*;

public class BJ_1092_배 {

	static int N, M, answer, count;
	static Integer[] crain, box;
	static boolean finish;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		crain = new Integer[N];
		for (int i = 0; i < N; i++) {
			crain[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		box = new Integer[M];
		v = new boolean[M];
		
		for (int i = 0; i < M; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(crain, Collections.reverseOrder());
		Arrays.sort(box, Collections.reverseOrder());
		
		answer = 0;
		count = 0;
		finish = false;
		
		while(true) {
			answer ++;
			boolean check = false;
			int idx = 0;
			for (int i = 0; i < box.length; i++) {
				if(!v[i] && idx<N && box[i] <= crain[idx]) {
					v[i] = true;
					idx++;
					count++;
					check = true;
				}
			}
			
			if(count == M) {
				finish = true;
				break;
			}
			if(!check) break;
			
		}
		System.out.println(finish?answer:(-1));
	}
	
}
