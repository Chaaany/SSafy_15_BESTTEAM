import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Work implements Comparable<Work>{
		int dur, end;
		
		Work(int dur, int end){
			this.dur = dur;
			this.end = end;
		}
		
		public int compareTo(Work o) {
			return Integer.compare(o.end, this.end);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Work> pq = new PriorityQueue<>();
		int sum = 0;
		int max = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a > b) {
				System.out.println(-1);
				return;
			}
			pq.add(new Work(a,b));
			sum += a;
			max = Math.max(max, b);
		}

		if(sum > max) {
			System.out.println(-1);
			return;
		}
		
		while(!pq.isEmpty()) {
			Work work = pq.poll();
			if(max > work.end) {
				max = work.end - work.dur;
			}
			else {
				max = max - work.dur;
			}
			
			if(max < 0) {
				max = -1;
				break;
			}
		}
		System.out.println(max);
	}

}
