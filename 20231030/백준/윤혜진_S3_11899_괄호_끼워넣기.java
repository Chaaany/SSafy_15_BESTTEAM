import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<>();
		String line = br.readLine();
		
		for (int i = 0; i < line.length(); i++) {
			if(!stack.isEmpty() && stack.peek() == '(' && line.charAt(i) == ')')
				stack.pop();
			else stack.push(line.charAt(i));
		}
		
		System.out.println(stack.size());
	}

}
