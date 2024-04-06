import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Assignment> stack = new Stack<>();
		int total = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				stack.push(new Assignment(score, time));
			}
			if (!stack.isEmpty()) {
				Assignment cur = stack.pop();
				int curScore = cur.score;
				int curTime = cur.time;
				curTime--;
				if (curTime == 0) {
					total += curScore;
				} else {
					stack.push(new Assignment(curScore, curTime));
				}
			}
		}
		System.out.println(total);
	}

	static class Assignment {
		int score;
		int time;

		public Assignment(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}

}
