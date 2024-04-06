import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i][0] = 1;
        }
        for (int i = 0; i < M; i++) {
            map[0][i] = 1;
        }
        if (K == 0) {
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < M; j++) {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
            System.out.println(map[N - 1][M - 1]);
        } else {
            int r = (K - 1) / M;
            int c = (K - 1) % M;
            for (int i = 1; i < r + 1; i++) {
                for (int j = 1; j < c + 1; j++) {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
            for (int i = r; i < N; i++) {
                map[i][c] = map[r][c];
            }
            for (int i = c; i < M; i++) {
                map[r][i] = map[r][c];
            }
            for (int i = r + 1; i < N; i++) {
                for (int j = c + 1; j < M; j++) {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
            System.out.println(map[N - 1][M - 1]);
        }
    }

}
