import java.io.*;
import java.util.*;

public class BJ_19941_햄버거분배 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		
		char[] arr = new char[N];
		boolean[] v = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = str.charAt(i);
		}
		
		// 그리디
		// 왼쪽에 있는 햄버거부터 먹어치운다
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i]=='P') {
				for (int j = i-K; j <= i+K; j++) {
					if(j>=0 && j<N && !v[j] && arr[j]=='H') {
						v[j]=true;
						answer++;
						break;
					}
				}
			}
		}
		System.out.println(answer);
	}

}
