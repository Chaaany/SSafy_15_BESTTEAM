import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_12789_DokiDokiGanSikDreamy {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> wait = new LinkedList<>();
		Stack<Integer> space = new Stack<>();
		int num = 1;
		for (int i = 0; i < N; i++) {
			wait.add(Integer.parseInt(st.nextToken()));
		}
		while (true) {
			int wait1 = 0;
			int space1 = 0;
			int cur = 0;
			if (!wait.isEmpty()) {
				wait1 = wait.peek();
			}
			if (!space.isEmpty()) {
				space1 = space.peek();
			}

			if (wait1 == num) {
				num++;
				wait.poll();
			} else {
				if (space1 == num) {
					num++;
					space.pop();
				} else {
					if (wait.isEmpty()) {
						break;
					} else {
						space.push(wait.poll());
					}
				}
			}
		}
		if (space.isEmpty()) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}

}
