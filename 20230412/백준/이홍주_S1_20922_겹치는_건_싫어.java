import java.io.*;
import java.util.*;

public class BJ_20922_겹치는건싫어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st=  new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxLength = 0;
		int now_idx = 0;
		int[] count = new int[100001];
		int nowLength  = 0;
		int left_idx=0;
		for (int i = 0; i < arr.length; i++) {
			if(count[arr[i]]<K) {
				count[arr[i]]++;
				nowLength++;
			}else {
				count[arr[i]]++;
				now_idx=i;
				int tmp = left_idx;
				int diff = 0;
			
				while(true) {
					count[arr[tmp]]--;					
					if(arr[tmp]==arr[now_idx]) {
						diff = now_idx - tmp;
						break;
					}					
					tmp++;				
				}
				left_idx = tmp+1;
				nowLength = diff;
			}
//			System.out.println(nowLength);
//			System.out.println(Arrays.toString(count));
			maxLength = Math.max(maxLength, nowLength);
		}
		System.out.println(maxLength);
	}

}
