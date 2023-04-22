import java.io.*;
import java.util.*;

public class BJ_1935_후위표기식2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		double[] number = new double[26];
		for (int i = 0; i < N; i++) {
			number[i] = (double) Integer.parseInt(br.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			
			if(now>='A' && now<='Z') {
				stack.add(number[now-'A']);
			}else {
				double back = stack.pop();
				double front = stack.pop();
				
				if(now=='+') {
					stack.add(front+back);
				}else if(now=='-') {
					stack.add(front-back);				
				}else if(now=='*') {
					stack.add(front*back);					
				}else if(now=='/') {
					stack.add(front/back);					
				}
			}
		}
		System.out.printf("%.2f", stack.pop());
	}

}
