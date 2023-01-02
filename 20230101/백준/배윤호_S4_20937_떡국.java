import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> que = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		que.add(pq.poll());
		while (!pq.isEmpty()) {
			int temp = pq.poll();
			if (temp == que.peek()) {
				answer++;
				que.add(temp);
			} else {
				que.add(temp);
				que.poll();
			}
		}
		System.out.println(answer);

	}

}
