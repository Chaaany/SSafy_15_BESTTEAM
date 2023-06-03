import java.io.*;
import java.util.*;

public class BJ_1965_상자넣기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] cost = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < cost.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 1;
		for (int i = 0; i < N; i++) {
			int max = 0;
			cost[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && max < cost[j]) {
					max  = cost[j];
					cost[i] = max + 1;
				}
			}
			answer = Math.max(answer, cost[i]);
		}

		System.out.println(answer);
	}


}
