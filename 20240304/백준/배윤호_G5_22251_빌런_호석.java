import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dif = new int[10][10];
    static int[] display;
    static int N, K, P, X;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        boolean[][] light = { { true, true, true, false, true, true, true },
                { false, false, true, false, false, true, false }, { true, false, true, true, true, false, true },
                { true, false, true, true, false, true, true }, { false, true, true, true, false, true, false },
                { true, true, false, true, false, true, true }, { true, true, false, true, true, true, true },
                { true, false, true, false, false, true, false }, { true, true, true, true, true, true, true },
                { true, true, true, true, false, true, true } };
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int cnt = 0;
                for (int k = 0; k < 7; k++) {
                    if (light[i][k] != light[j][k]) {
                        cnt++;
                    }
                }
                dif[i][j] = cnt;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        // N개의 층, K자리 수, P개 변경, 실제 X층
        display = new int[K];
        String s = X + "";
        int length = display.length - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            display[length--] = s.charAt(i) - 48;
        }
        find(0, 0, "0");
        System.out.println(ans);
    }

    private static void find(int zari, int change, String s) {
        // System.out.println(zari+" "+change+" "+s);
        if (change > P || Integer.parseInt(s) > N) {
            return;
        }
        if (zari == K) {
            if (Integer.parseInt(s) != 0 && Integer.parseInt(s) != X) {
                ans++;
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            find(zari + 1, change + dif[display[zari]][i], s + i);
        }

    }

}
