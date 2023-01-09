import java.io.*;
import java.util.*;

public class BJ_21773_가희와프로세스1 {

	public static class Process implements Comparable<Process>{
		int id;
		int time;
		int pri;
		
		public Process(int id, int time, int pri) {
			super();
			this.id = id;
			this.time = time;
			this.pri = pri;
		}
		
		@Override
		public int compareTo(Process p) {
			if(p.pri != this.pri) return p.pri - this.pri;
			else return this.id - p.id;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		
		PriorityQueue<Process> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Process(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));			
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			if(!pq.isEmpty()) {
				Process pro = pq.poll();
				sb.append(pro.id+"\n");				
				
				
				if(pro.time>1) pq.add(new Process(pro.id, pro.time-1, pro.pri-1));
			}
		}
		System.out.println(sb.toString());
	}
}
