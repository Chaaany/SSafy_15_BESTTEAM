import java.io.*;
import java.util.*;

public class BJ_2036_수열의점수 {

	
	static int N;
	static long[] arr;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N =  Integer.parseInt(br.readLine());
		arr = new long[N];
		v = new boolean[N];
		
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		long answer = 0;
		int idx = 0;
		
		// 음수 끼리는 제일 작은수부터 곱해야 된다.
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			if(arr[i] <= 0) {
				v[i] = true;
				answer += minus(i);
			} else {
				idx=i;
				break;
			}
			
		}
		
		
		// 양수끼리는 제일 큰수끼리 곱해야 된다.
		for (int i = N-1; i >= idx; i--) {
			if(v[i]) continue;
			if(arr[i] > 0) {
				v[i] = true;
				answer += plus(i);			
			}else break;
		}
		
		System.out.println(answer);
	}
	
	
	private static long plus(int end) {
		for (int i = end-1; i >= 0; i--) {
			if(v[i]) continue;
			if(arr[i] <= 0) return arr[end];
			else {
				// 만약 둘이 같거나 더 작기라도 하면 그냥 내보내는게 이득
				if(arr[i] * arr[end] <= arr[end]) return arr[end];
				v[i] = true;
				return arr[i] * arr[end];
			}
		}
		return arr[end];
	}
	
	private static long minus(int start) {
		for (int i = start+1; i < N; i++) {
			if(v[i]) continue;
			if(arr[i] > 0) return arr[start];
			else {
				// 만약 둘이 같거나 더 작기라도 하면 그냥 내보내는게 이득
				if(arr[i] * arr[start] <= arr[start]) return arr[start];
				v[i] = true;
				return arr[i] * arr[start];
			}
		}
		return arr[start];
	}

}
