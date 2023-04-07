import java.io.*;
import java.util.*;

public class BJ_1863_스카이라인쉬운거 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			
			while(!stack.isEmpty()) {	
				int top = stack.peek();
				if(top >= y) {
					stack.pop();
					if(top > y) answer++;
				}else break;				
			}
			
			
			stack.push(y);
		
		}
		
		while(!stack.isEmpty()) {	
			int now = stack.pop();
			if(now!=0) answer++;			
		}
		System.out.println(answer);
	}
	
}
