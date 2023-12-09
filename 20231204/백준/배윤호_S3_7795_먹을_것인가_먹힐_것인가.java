import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            int ans = 0;
            Arrays.sort(A);
            Arrays.sort(B);
            int left = 0;
            int right = M - 1;
            int mid = 0;
            for (int i = 0; i < N; i++) {
                left = mid;
                right = M - 1;
                int cur = A[i];
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (B[mid] < cur) {
                        left = mid + 1;
                    } else if (B[mid] > cur) {
                        right = mid - 1;
                    } else {
                        right--;
                    }
                }
                if (B[mid] < cur) {
                    ans += (mid + 1);
                } else {
                    ans += mid;
                }

            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

}
