import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int pass = 0;
		Stack<Integer> stack = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			while(!stack.isEmpty()) {
				if(stack.peek() == pass+1) pass = stack.pop();
				else break;
			}

			int cur = Integer.parseInt(st.nextToken());
			if(cur == pass+1) pass = cur;
			else stack.push(cur);
			
			System.out.println(pass);
		}
		
		// 스택에 남은 번호 처리
		while(!stack.isEmpty()) {
			if(stack.peek() == pass+1) pass = stack.pop();
			else break;
		}

		System.out.println(pass == N?"Nice":"Sad");
	}

}
