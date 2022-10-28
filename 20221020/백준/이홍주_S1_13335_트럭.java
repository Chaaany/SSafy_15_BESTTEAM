import java.io.*;
import java.util.*;

public class BJ_13335_트럭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int time = 0;
		st = new StringTokenizer(br.readLine());
		int[] truck = new int[N];
		for (int i = 0; i < N; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}
		int last_idx = 0;
		int now_weight = 0;
		Queue<Integer> qu = new LinkedList<Integer>();
		for (int i = 0; i < W; i++) {
			qu.add(0);
		}
		while(!qu.isEmpty()) {
			int x = qu.poll();
			now_weight-=x;
			if(now_weight==0 && last_idx == N) break;
			time++;
			if(last_idx<N && now_weight+truck[last_idx]<=L) {
				qu.add(truck[last_idx]);
				now_weight +=truck[last_idx++];			
			}
			else qu.add(0);
		}
		System.out.println(time+1);
	}
}
