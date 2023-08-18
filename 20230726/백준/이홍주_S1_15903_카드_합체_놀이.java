import java.io.*;
import java.util.*;

public class BJ_15903_카드합체놀이 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(st.nextToken()));		
		}
		
		for (int i = 0; i < m; i++) {
			long x = pq.poll();
			long y = pq.poll();
			
			pq.add(x+y);
			pq.add(x+y);
		}
		
		long answer = 0;
		while(!pq.isEmpty()) {
			answer += pq.poll();
		}
		System.out.println(answer);
	}


}
