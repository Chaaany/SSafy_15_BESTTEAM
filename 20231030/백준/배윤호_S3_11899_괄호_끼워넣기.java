import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] brackets = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : brackets) {
            if (stack.size() == 0) {
                stack.push(c);
                continue;
            }
            if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        System.out.println(stack.size());
    }

}
