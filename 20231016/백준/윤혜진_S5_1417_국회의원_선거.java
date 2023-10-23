import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static class Candidate implements Comparable<Candidate> {
		int idx;
		int cnt;
		
		public Candidate(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
		public int compareTo(Candidate o) {
			return o.cnt - this.cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Candidate> pq = new PriorityQueue<>();
		
		Candidate som = new Candidate(1, Integer.parseInt(br.readLine()));
		for (int i = 2; i <= N; i++) {
			pq.add(new Candidate(i, Integer.parseInt(br.readLine())));
		}
		
		int count = 0;
		while(!pq.isEmpty()) {
			Candidate cur = pq.poll();
			if(som.cnt > cur.cnt) break;
			
			count++;
			cur.cnt--;
			som.cnt++;
			pq.add(cur);
		}
		
		System.out.println(count);
	}

}
