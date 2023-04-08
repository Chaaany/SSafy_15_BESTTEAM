import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int[] h = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			h[i] = y;
		}
		Stack<Integer> stack = new Stack<>();
		for (int i : h) {
			if (i == 0) {
				count += stack.size();
				stack.clear();
			} else if (!stack.isEmpty()) {
				if (stack.peek() < i) {
					stack.push(i);
				} else {
					while (!stack.isEmpty() && stack.peek() > i) {
						stack.pop();
						count++;
					}
					if (!stack.isEmpty() && stack.peek() < i)
						stack.push(i);
					if (stack.isEmpty())
						stack.push(i);
				}
			} else {
				stack.push(i);
			}
		}
		count += stack.size();
		System.out.println(count);
	}

}
