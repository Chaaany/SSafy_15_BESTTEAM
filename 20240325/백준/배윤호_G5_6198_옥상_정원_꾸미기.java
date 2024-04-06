import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		long ans = 0;
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(br.readLine());

			while (!stack.isEmpty()) {

				if (stack.peek() <= cur) {
					stack.pop();
				} else
					break;
			}
			ans += stack.size();
			stack.push(cur);
		}
		System.out.println(ans);
	}

}
