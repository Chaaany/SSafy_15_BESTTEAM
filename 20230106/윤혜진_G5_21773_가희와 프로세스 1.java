import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Process> pq = new PriorityQueue<>(new Comparator<Process>() {

			@Override
			public int compare(Process o1, Process o2) {
				if(o1.priority == o2.priority)
					return o1.id - o2.id;
				return o2.priority - o1.priority;
			}
		});
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int priority = Integer.parseInt(st.nextToken());
			pq.add(new Process(id, time, priority));
		}
		
		for (int i = 0; i < T; i++) {
			if(pq.isEmpty()) break;
			
			Process p = pq.poll();
			sb.append(p.id + "\n");
			
			p.priority = p.priority-1;
			p.time = p.time-1;
			
			if(p.time > 0)
				pq.add(p);
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}
	
	public static class Process {
		int id;
		int time;
		int priority;
		
		public Process(int id, int time, int priority) {
			this.id = id;
			this.time = time;
			this.priority = priority;
		}
	}

}
