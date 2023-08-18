import java.io.*;
import java.util.*;

public class BJ_2879_코딩은예쁘게 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] now = new int[N]; // 현재 탭 개수
		int[] change = new int[N]; // 추가 혹은 삭제해야되는 탭 개수
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			now[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			change[i] = Integer.parseInt(st.nextToken()) - now[i];
		}
		
		int before = 0;
		int answer = 0;
		
		if(N>1) {
			before = change[0];
			for (int i = 1; i < N; i++) {
				// 부호가 바뀌면
				if(before*change[i] < 0) {
					answer += Math.abs(before);
				}else if(Math.abs(before) >= Math.abs(change[i])) {
					answer += Math.abs(before) - Math.abs(change[i]);
				}
				before = change[i];
			}
		}else answer = change[0];
		answer += Math.abs(before);
		System.out.println(answer);
	}

}
