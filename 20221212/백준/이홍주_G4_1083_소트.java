import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st=  new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());			
		}
		
		int S = Integer.parseInt(br.readLine());
	
		int count = S;		
		int start_idx = 0;
	
		while(true) {
			if(count<=0 || start_idx>= N-1 ) break;
			int max = arr[start_idx];
			int max_idx = start_idx;
			
			for (int i = start_idx+1; i <= start_idx + count; i++) {
				if(i > N-1) break;
				if(max < arr[i]) {
					max = arr[i];
					max_idx = i;
				}
			}
			
			if(max_idx!=start_idx) {
				for (int i = max_idx; i > start_idx; i--) {
					swap(i,arr);
				}
				count -= max_idx-start_idx;
			}
			start_idx++;			
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static void swap(int i, int[] arr) {
		int tmp = arr[i];
		arr[i] = arr[i-1];
		arr[i-1] = tmp;
	}
}
