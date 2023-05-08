import java.io.*;
import java.util.*;

public class BJ_2075_N번째큰수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
		}
		
		for (int i = 0; i < N-1; i++) {
			if(!pq.isEmpty()) pq.poll();
		}
		
		System.out.println(pq.peek());
	}
}
