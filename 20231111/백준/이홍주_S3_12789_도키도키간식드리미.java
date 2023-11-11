import java.io.*;
import java.util.*;

public class BJ_12789_도키도키간식드리미 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N =  Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int now = 0;
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			if(arr[i]-now > 1) {
				if(!stack.isEmpty() && stack.peek()-now==1){
					now++;
					stack.pop();
					i--;
				}else stack.push(arr[i]);
			}
			else now++;
		}
		
		while(!stack.isEmpty()) {
			if(stack.peek()-now>1) break;
			else now++;
			
			stack.pop();
		}
		
		System.out.println(stack.size()==0?"Nice":"Sad");
	}


}
