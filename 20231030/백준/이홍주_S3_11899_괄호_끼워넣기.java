import java.io.*;
import java.util.Stack;

public class BJ_11899_괄호끼워넣기 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			if(stack.isEmpty()) {
				if(now == ')') answer++;
				else stack.push(now);
			}else {
				if(now == ')') stack.pop();
				else stack.push(now);
			}
		}
		answer += stack.size();
		System.out.println(answer);
	}

	

}
