import java.io.*;
import java.util.*;

public class BJ_1253_좋다 {

	// 투포인터
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
				
		int count = 0;
		if(arr.length<=2) {
			System.out.println(count);
			return;
		}else {
			Arrays.sort(arr);
			for (int i = 0; i < N; i++) {
				int start_idx = 0;
				int end_idx = N-1;
				
				while(start_idx<end_idx) {
					if(start_idx == i) { 
						start_idx++;
						continue;
					}
					if(end_idx == i) {
						end_idx--;
						continue;
					}
					
					if(arr[i] == arr[start_idx]+arr[end_idx]) {
						count++;
						break;
					}
					else if(arr[i] > arr[start_idx]+arr[end_idx]) {
						start_idx++;
						
					}else { 
						end_idx--;
					}
				}
			}			
		}
		System.out.println(count);
	}

}
