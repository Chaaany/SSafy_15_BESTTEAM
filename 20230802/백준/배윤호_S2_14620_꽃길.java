import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] v;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        plant(0, 0);
        System.out.println(ans);
    }

    private static void plant(int flower, int cost) {
        if (flower == 3) {
            ans = Integer.min(ans, cost);
            return;
        }
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (check(i, j)) {
                    v[i][j] = true;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        v[nr][nc] = true;
                    }
                    plant(flower + 1, cost + map[i][j] + map[i - 1][j] + map[i][j + 1] + map[i + 1][j] + map[i][j - 1]);
                    v[i][j] = false;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        v[nr][nc] = false;
                    }
                }
            }
        }

    }

    private static boolean check(int i, int j) {
        boolean check = true;
        for (int d = 0; d < 4; d++) {
            int nr = dr[d] + i;
            int nc = dc[d] + j;
            if (v[nr][nc]) {
                check = false;
                break;
            }
        }
        return check;
    }

}
