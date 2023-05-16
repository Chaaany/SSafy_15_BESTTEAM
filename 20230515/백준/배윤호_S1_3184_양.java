import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int R, C;
    static char[][] map;
    static boolean[][] v;
    static int sheep, wolf = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        v = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            if (!v[i][0] && map[i][0] == '.') {
                check(i, 0);
            }
            if (!v[i][C - 1] && map[i][C - 1] == '.') {
                check(i, C - 1);
            }
        }
        for (int i = 0; i < C; i++) {
            if (!v[0][i] && map[0][i] == '.') {
                check(0, i);
            }
            if (!v[R - 1][i] && map[R - 1][i] == '.') {
                check(R - 1, i);
            }
        }
        for (int i = 1; i < R - 1; i++) {
            for (int j = 1; j < C - 1; j++) {
                if (!v[i][j] && map[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    private static void bfs(int i, int j) {
        v[i][j] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { i, j });
        int s = 0;
        int w = 0;
        if (map[i][j] == 'o') {
            s++;
        } else if (map[i][j] == 'v') {
            w++;
        }
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !v[nr][nc] && map[nr][nc] != '#') {
                    v[nr][nc] = true;
                    que.add(new int[] { nr, nc });
                    if (map[nr][nc] == 'o') {
                        s++;
                    } else if (map[nr][nc] == 'v') {
                        w++;
                    }
                }
            }
        }
        if (s > w) {
            sheep += s;
        } else {
            wolf += w;
        }
    }

    private static void check(int i, int j) {
        v[i][j] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { i, j });
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !v[nr][nc] && map[nr][nc] == '.') {
                    v[nr][nc] = true;
                    que.add(new int[] { nr, nc });
                }
            }
        }

    }

}
