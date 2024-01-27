import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }
        int before = points[N - 1];
        int ans = 0;
        for (int i = N - 2; i >= 0; i--) {
            if (before <= points[i]) {
                ans += points[i] - before + 1;
                points[i] = before - 1;
            }
            before = points[i];
        }
        System.out.println(ans);
    }

}
