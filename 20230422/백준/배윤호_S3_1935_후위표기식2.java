import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BJ_1935_PostOrder2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		Stack<Double> stack = new Stack<>();
		Map<Character, Double> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			Double temp = Double.parseDouble(br.readLine());
			map.put((char)('A'+i), temp);
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(stack.isEmpty()) {
				stack.push(map.get(c));
			}
			if(c>='A' && c<='Z') {
				stack.push(map.get(c));
			}
			else {
				Double l1 = stack.pop();
				Double l2 = stack.pop();
				switch(c) {
				case '+':
					stack.push(l2+l1);
					break;
				case '-':
					stack.push(l2-l1);
					break;
				case '*':
					stack.push(l2*l1);
					break;
				case '/':
					stack.push(l2/l1);
					break;
				}
			}
		}
		System.out.printf("%.2f", stack.peek());
	}

}
