import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean cango = false;
        int time = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][][] v = new boolean[N][M][2];
        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken()) - 1;
        int sc = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        int er = Integer.parseInt(st.nextToken()) - 1;
        int ec = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { sr, sc, 1 });
        v[sr][sc][1] = true;
        go: while (!que.isEmpty()) {
            int size = que.size();
            time++;
            for (int i = 0; i < size; i++) {
                int[] cur = que.poll();
                int cr = cur[0];
                int cc = cur[1];
                int cm = cur[2];
                for (int d = 0; d < 4; d++) {
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        if (map[nr][nc] == 1) {
                            if (cm == 1) {
                                if (map[nr][nc] == 1 && !v[nr][nc][cm - 1]) {
                                    if (nr == er && nc == ec) {
                                        cango = true;
                                        break go;
                                    }
                                    que.add(new int[] { nr, nc, cm - 1 });
                                    v[nr][nc][cm - 1] = true;
                                } else if (map[nr][nc] == 0 && !v[nr][nc][cm]) {
                                    if (nr == er && nc == ec) {
                                        cango = true;
                                        break go;
                                    }
                                    que.add(new int[] { nr, nc, cm });
                                    v[nr][nc][cm] = true;
                                }
                            }
                        } else {
                            if (map[nr][nc] == 0 && !v[nr][nc][cm]) {
                                if (nr == er && nc == ec) {
                                    cango = true;
                                    break go;
                                }
                                que.add(new int[] { nr, nc, cm });
                                v[nr][nc][cm] = true;
                            }
                        }

                    }
                }
            }
        }
        if (!cango) {
            time = -1;
        }
        System.out.println(time);
    }

}
