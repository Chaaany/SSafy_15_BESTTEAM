import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = arr[0];
        int min = 0;
        int dif = 0;
        for (int i = 1; i < N; i++) {
            dif += arr[i] - arr[0];
        }
        min = dif;

        for (int i = 1; i < N; i++) {
            int cur = arr[i];
            int j = i - 1;
            int k = N - (i + 1);
            dif = dif + (j * (cur - arr[i - 1]));
            dif = dif - (k * (cur - arr[i - 1]));
            if (min > dif) {
                ans = arr[i];
                min = dif;
            }
        }
        System.out.println(ans);
    }

}
