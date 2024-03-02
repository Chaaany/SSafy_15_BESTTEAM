import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<String> que;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        que = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            int num = i * 100;
            for (int j = 1; j < 10; j++) {
                if (i == j)
                    continue;
                num += j * 10;
                for (int k = 1; k < 10; k++) {
                    if (i == k || j == k)
                        continue;
                    num += k;
                    que.add(num + "");
                    num -= k;
                }
                num -= j * 10;
            }
            num -= i * 100;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            check(num, s, b);
        }
        System.out.println(que.size());

    }

    private static void check(int num, int s, int b) {
        int size = que.size();
        char[] arr = (num + "").toCharArray();
        for (int i = 0; i < size; i++) {
            String cur = que.poll();
            int cs = 0;
            int cb = 0;
            for (int j = 0; j < 3; j++) {
                if (cur.contains(arr[j] + "")) {
                    if (cur.charAt(j) == arr[j]) {
                        cs++;
                    } else {
                        cb++;
                    }
                }
            }
            if (s == cs && b == cb) {
                que.add(cur);
            }
        }

    }

}
