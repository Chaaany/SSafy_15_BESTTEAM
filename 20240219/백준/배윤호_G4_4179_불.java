import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Queue<int[]> jh = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();
        boolean[][] v = new boolean[R][C]; // 지훈
        boolean[][] fireV = new boolean[R][C]; // 불
        boolean escape = false;
        int time = 0;
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'J') {
                    jh.add(new int[] { i, j });
                    v[i][j] = true;
                } else if (map[i][j] == 'F') {
                    fire.add(new int[] { i, j });
                    fireV[i][j] = true;
                }
            }
        }
        int[] first = jh.poll();
        if (first[0] == 0 || first[0] == R - 1 || first[1] == 0 || first[1] == C - 1) {
            System.out.println(1);
            return;
        }
        jh.add(first);
        go: while (!jh.isEmpty()) {
            time++;
            // 불지르기
            int size = fire.size();

            for (int i = 0; i < size; i++) {
                int[] cur = fire.poll();
                int cr = cur[0];
                int cc = cur[1];
                for (int d = 0; d < 4; d++) {
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != '#' && !fireV[nr][nc]) {
                        fire.add(new int[] { nr, nc });
                        fireV[nr][nc] = true;
                        map[nr][nc] = 'F';
                    }
                }
            }

            size = jh.size();
            // 지훈이 이동하기
            for (int i = 0; i < size; i++) {
                int[] cur = jh.poll();
                int cr = cur[0];
                int cc = cur[1];
                for (int d = 0; d < 4; d++) {
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.' && !v[nr][nc]) {
                        if (nr == 0 || nc == 0 || nr == R - 1 || nc == C - 1) {
                            escape = true;
                            break go;
                        }
                        v[nr][nc] = true;
                        jh.add(new int[] { nr, nc });
                    }
                }
            }
        }
        if (escape) {
            System.out.println(time + 1);
        } else {
            System.out.println("IMPOSSIBLE");
        }

    }

}
