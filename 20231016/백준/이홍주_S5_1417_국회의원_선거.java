import java.io.*;
import java.util.*;

public class BJ_1417_국회의원선거 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int dasom = Integer.parseInt(br.readLine());
		int answer = 0;
		
		
		for (int i = 0; i < N-1; i++) pq.add(Integer.parseInt(br.readLine()));
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			
			if(dasom <= now) {
				dasom ++;
				answer++;
				pq.add(now-1);
			}else break;
		}
		
		System.out.println(answer);
	}

	
}
