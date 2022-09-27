import java.io.*;
import java.util.*;
public class Main {

	static class Ban implements Comparable<Ban>{
		int start;
		int end;
		public Ban(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}		
		@Override
		public int compareTo(Ban o1) {
			return this.start-o1.start;
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		ArrayList<Ban> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Ban(start,end));
		}
		
		Collections.sort(list);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(Ban ban : list) {	
			if(pq.size()==0) {
				pq.add(ban.end);
				continue;
			}
			int min = pq.peek();
			if(min>ban.start) {
				pq.add(ban.end);
			}else {
				pq.poll();
				pq.add(ban.end);
			}
		}
		System.out.println(pq.size());
	}

}
