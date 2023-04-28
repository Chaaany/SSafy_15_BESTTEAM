import java.io.*;
import java.util.*;

public class BJ_2812_크게만들기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		
		
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			int now = str.charAt(i) - '0';
			
			while(!stack.isEmpty() && count<K) {
				if(stack.peek()<now) {
					stack.pop();
					count++;
				}else break;
			}
			
			stack.add(now);			
		}
		
		// 만약 끝까지 왔는데 다 못뺐다면
		if(count<K) {
			while(!stack.isEmpty()) {
				stack.pop();
				count++;
				if(count>=K) break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			// 거꾸로 문자열 만들기
			sb.insert(0, stack.pop());
		}
		System.out.println(sb.toString());
	}

}
