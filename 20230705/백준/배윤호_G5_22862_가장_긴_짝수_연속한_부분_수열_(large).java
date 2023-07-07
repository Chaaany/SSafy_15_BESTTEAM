import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int seq = 0;
        int left = 0;
        int right = 0;
        while (true) {
            if (arr[right] % 2 == 0) {
                seq++;
                right++;
                max = Math.max(max, seq);
            } else {
                if (K > 0) {
                    K--;
                    right++;
                } else {
                    if (arr[left] % 2 != 0) {
                        K++;
                    } else {
                        seq--;
                    }
                    left++;
                }
            }

            if (right == N)
                break;
        }
        System.out.println(max);
    }

}
