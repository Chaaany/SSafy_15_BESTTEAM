import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int ans = 0;
    static int N = 0;
    static boolean[][] v = new boolean[21][1001];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        find(0, 0);
        System.out.println(ans);
    }

    private static void find(int cnt, int sum) {
        if (cnt == N) {
            ans++;
            return;
        }
        if (!v[cnt + 1][sum + 1]) {
            v[cnt + 1][sum + 1] = true;
            find(cnt + 1, sum + 1);
        }
        if (!v[cnt + 1][sum + 5]) {
            v[cnt + 1][sum + 5] = true;
            find(cnt + 1, sum + 5);
        }
        if (!v[cnt + 1][sum + 10]) {
            v[cnt + 1][sum + 10] = true;
            find(cnt + 1, sum + 10);
        }
        if (!v[cnt + 1][sum + 50]) {
            v[cnt + 1][sum + 50] = true;
            find(cnt + 1, sum + 50);
        }

    }

}
