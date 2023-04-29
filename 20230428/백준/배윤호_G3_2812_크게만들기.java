import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2812_MakeBigger {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			int a = s.charAt(i) - 48;
			if (stack.isEmpty()) {
				stack.push(a);
				continue;
			}
			while (true) {
				if (stack.isEmpty()) {
					stack.push(a);
					break;
				}
				if (stack.peek() < a) {
					if (K > 0) {
						stack.pop();
						K--;
					} else {
						stack.push(a);
						break;
					}
				} else {
					stack.push(a);
					break;
				}
			}
		}
		while (K > 0) {
			stack.pop();
			K--;
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}
		System.out.println(sb);
	}

}
