import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static class Guitar implements Comparable<Guitar> {
		String serial;
		
		public Guitar(String serial) {
			this.serial = serial;
		}
		
		public int compareTo(Guitar o) {
			if(this.serial.length() == o.serial.length()) {
				int sumA = 0;
				int sumB = 0;
				
				for (int i = 0; i < this.serial.length(); i++) {
					int cA = this.serial.charAt(i) - '0';
					int cB = o.serial.charAt(i) - '0';
					if(0 <= cA && cA <= 9) sumA += cA;
					if(0 <= cB && cB <= 9) sumB += cB;
				}
				
				if(sumA == sumB)
					return this.serial.compareTo(o.serial);
				
				return sumA - sumB;
			}
			return this.serial.length() - o.serial.length();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Guitar> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			pq.add(new Guitar(br.readLine()));
		}
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll().serial+"\n");
		}
		
		System.out.println(sb);
	}

}
