import java.io.*;
import java.util.*;

public class BJ_2141_우체국 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		long count = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
			count += arr[i][1];
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
			
		} );
		
		long cnt = 0;
		long answer = arr[N-1][0];
		
		for (int i = 0; i < N; i++) {
			cnt += arr[i][1];
			// 왜 +1??
			if(cnt >= (count+1)/2) {
				answer = arr[i][0];
				break;
			}
		}
		
		System.out.println(answer);
	}	
	
}
