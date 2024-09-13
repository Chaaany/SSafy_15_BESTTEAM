import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(st.nextToken());
        int cmd = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    sb.append((stack.isEmpty() ? -1 : stack.pop())).append("\n");
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    sb.append(stack.isEmpty()?1:0).append("\n");
                    break;
                case 5:
                    sb.append(stack.isEmpty()?-1:stack.peek()).append("\n");
                    break;
                default:
                    break;
            }
        }
        sb.setLength(Math.max(sb.length() - 1, 0));
        System.out.println(sb.toString());
    }
}
