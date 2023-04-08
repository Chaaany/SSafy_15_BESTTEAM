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
		Stack<Integer> stack = new Stack<>();
		
		int count = 0;
		for (int i = 0; i <= N; i++) {
			int x, y = 0;
			
			if(i<N) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
			}
			else y = 0;
			
			if(stack.isEmpty() || y>stack.peek()) stack.push(y);
			else if(y < stack.peek()){
				int size = stack.size();
				for(int j = 0; j < size; j++) {
					if(stack.peek() > y) {
						count++;
						stack.pop(); 
					}
				}		
				if(stack.isEmpty() || stack.peek() != y) 
					stack.push(y);
			}

		}
		
		System.out.println(count);
	}

}
