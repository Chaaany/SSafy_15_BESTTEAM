import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int ans = 0;
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < maxIndex; i++) {
            ans += (arr[i] + max);
        }
        for (int i = maxIndex + 1; i < N; i++) {
            ans += (arr[i] + max);
        }
        System.out.println(ans);
    }

}
