import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		PriorityQueue<Process> pr = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			pr.add(new Process(A, B, C));
		}

		for (int i = 0; i < T; i++) {
			if (pr.isEmpty())
				break;
			Process temp = pr.poll();
			sb.append(temp.id + "\n");
			temp.priority--;
			temp.time--;
			if (temp.time > 0) {
				pr.add(temp);
			}
		}
		System.out.println(sb);
	}

	public static class Process implements Comparable<Process> {
		private int id;
		private int time;
		private int priority;

		public Process(int id, int time, int priority) {
			this.id = id;
			this.time = time;
			this.priority = priority;
		}

		@Override
		public int compareTo(Process p1) {
			if (p1.priority == this.priority) {
				return this.id - p1.id;
			}
			return p1.priority - this.priority;
		}
	}

}
