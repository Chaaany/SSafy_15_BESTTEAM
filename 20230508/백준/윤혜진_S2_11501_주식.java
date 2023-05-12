import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Node implements Comparable<Node>{
		long value;
		int idx;
		
		public Node(long value, int idx) {
			this.value = value;
			this.idx = idx;
		}
		
		public int compareTo(Node o) {
			return (int) (o.value - this.value);
		}
	}
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			long[] num = new long[N+1];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Long.parseLong(st.nextToken());
				pq.add(new Node(num[i], i));
			}
			
			long sum = 0;
			int count = 0;
			Node node = pq.poll();
			for (int i = 0; i < N; i++) {
				if(node.idx > i) {
					sum -= num[i];
					count++;
				}
				else if(node.idx == i) {
					sum += count*num[i];
					count = 0;
                    while(!pq.isEmpty() && node.idx <= i) {
                        node = pq.poll();    
                    }
				}
				else continue;
			}
			
			sb.append(sum+"\n");
		}
		
		System.out.println(sb);
	}

}
