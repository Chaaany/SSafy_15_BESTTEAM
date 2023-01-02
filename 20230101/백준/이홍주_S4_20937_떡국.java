import java.io.*;
import java.util.*;

public class BJ_20937_떡국 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
			
		int max = 1;
		int count = 1;
		int before = 0;
		
		while(!pq.isEmpty()) {
			int x = pq.poll();
			if(x == before) {
				count++;
			}else {
				max = Math.max(max, count);
				count  = 1;
			}
			before = x;
		}
		
		System.out.println(Math.max(max, count));
	}
}
