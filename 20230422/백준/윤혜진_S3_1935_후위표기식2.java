import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		double[] num = new double[N];
		Stack<Double> stack = new Stack<>();
		
		String line = br.readLine();
		for (int i = 0; i < N; i++) {
			num[i] = Double.parseDouble(br.readLine());
		}
		
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			
			if(c >= 'A' && c <= 'Z') {
				stack.push(num[c-'A']);
			}
			else {
				double a = stack.pop();
				double b = stack.pop(); 
				if (c == '+') {
					stack.push(a+b);
				}
				else if (c == '-') {
					stack.push(b-a);
				} else if (c == '*') {
					stack.push(a*b);
				} else if (c == '/') {
					stack.push(b/a);
				}
			}
		}
		
		System.out.println(String.format("%.2f", stack.pop()));
	}

}
