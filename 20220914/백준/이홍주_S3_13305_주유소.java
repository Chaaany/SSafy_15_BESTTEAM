import java.io.*;
import java.util.*;

public class BJ_13305_주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));	
		int N = Integer.parseInt(br.readLine());
		
		int[] city = new int[N];
		int[] distance= new int[N-1];
		long total_dis=0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			distance[i]=  Integer.parseInt(st.nextToken());
			total_dis += distance[i];
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		
		int min_idx = N-1;
		int max_idx = N-1;
		long res = 0;
		long tmp_dis  = 0;
		while(true) {			
			int min = Integer.MAX_VALUE;
			int tmp = min_idx;
			for (int i = 0; i < tmp; i++) {
				if (min > city[i]) {
					min = city[i];
					min_idx = i;
				}
			}
			long sum = 0;
			for (int i = min_idx; i < max_idx; i++) {
				sum+=distance[i];
			}
			max_idx = min_idx;
			res += min * sum;
			tmp_dis += sum;
			if(tmp_dis == total_dis) break;
		}		
		System.out.println(res);		
	}
}
