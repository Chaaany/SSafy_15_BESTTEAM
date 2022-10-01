import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		List<Lecture> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Lecture(start, end));
		}
		Collections.sort(list);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(list.get(0).end);
		for (int i = 1; i < list.size(); i++) {
			if (pq.peek() <= list.get(i).start) {
				pq.poll();
				pq.add(list.get(i).end);
			} else {
				pq.add(list.get(i).end);
			}
		}
		System.out.println(pq.size());

	}

	static class Lecture implements Comparable<Lecture> {
		int start;
		int end;

		Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {
			return this.start - o.start;
		}
	}

}
