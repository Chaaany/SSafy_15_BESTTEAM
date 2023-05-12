import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				if(pq.size() == N) {
					if(pq.peek() < cur) {
						pq.poll();
						pq.add(cur);
					}
				}
				else pq.add(cur);
			}
		}
		
		System.out.println(pq.poll());
	}

}
