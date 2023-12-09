import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class BJ_20311_화학실험 {

	
	static int N,K;
	
	static class Color implements Comparable<Color>{
		int idx;
		int cnt;
		public Color(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Color o) {
			if(this.cnt==o.cnt) return this.idx-o.idx;
			else return o.cnt-this.cnt;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Color> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= K; i++) {
			pq.add(new Color(i,Integer.parseInt(st.nextToken())));
		}
		
		int before = 0;
		StringBuilder sb= new StringBuilder();
		while(!pq.isEmpty()) {
			Color color = pq.poll();
			if(color.idx==before) {
				if(!pq.isEmpty()) {
					Color tmp = pq.poll();
					sb.append(tmp.idx+" ");
					if(tmp.cnt!=1) pq.add(new Color(tmp.idx, tmp.cnt-1));
					pq.add(color);
					before = tmp.idx;
				}else {
					pq.add(color);
					break;
				}
				continue;
			}
			
			sb.append(color.idx+" ");
			if(color.cnt!=1) pq.add(new Color(color.idx, color.cnt-1));
			before = color.idx;
			
		}
		sb.setLength(sb.length()-1);
		if(!pq.isEmpty()) System.out.println("-1");
		else System.out.println(sb.toString());
	}


}
