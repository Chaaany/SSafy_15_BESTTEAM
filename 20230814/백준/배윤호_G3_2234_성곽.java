import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int[][][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int[][] v;
    static int rooms = 0;
    static int maxArea = 0;
    static int twoSum = 0;
    static int roomNo = 1;
    static Map<Integer, Integer> roomArea = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C][4]; // 0 1 2 3 상 우 하 좌
        v = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp >= 8) {
                    map[i][j][2] = 1;
                    temp -= 8;
                }
                if (temp >= 4) {
                    map[i][j][1] = 1;
                    temp -= 4;
                }
                if (temp >= 2) {
                    map[i][j][0] = 1;
                    temp -= 2;
                }
                if (temp >= 1) {
                    map[i][j][3] = 1;
                    temp -= 1;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (v[i][j] == 0) {
                    find(i, j);
                    rooms++;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                wallBreak(i, j);
            }
        }
        System.out.println(rooms);
        System.out.println(maxArea);
        System.out.println(twoSum);

    }

    private static void find(int i, int j) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { i, j });
        v[i][j] = roomNo;
        int area = 1;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            for (int d = 0; d < 4; d++) {
                if (map[r][c][d] == 1)
                    continue;
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && v[nr][nc] == 0) {
                    v[nr][nc] = roomNo;
                    area++;
                    que.add(new int[] { nr, nc });
                }
            }
        }
        roomArea.put(roomNo, area);
        maxArea = Math.max(area, maxArea);
        roomNo++;
    }

    private static void wallBreak(int i, int j) {
        boolean[] checkList = new boolean[4];
        if (i == 0) {
            checkList[0] = true;
        }
        if (j == 0) {
            checkList[3] = true;
        }
        if (i == R - 1) {
            checkList[2] = true;
        }
        if (j == C - 1) {
            checkList[1] = true;
        }
        for (int d = 0; d < 4; d++) {
            if (map[i][j][d] == 1 && !checkList[d]) {
                int nr = i + dr[d];
                int nc = j + dc[d];
                if (v[i][j] == v[nr][nc])
                    continue;
                int sum = roomArea.get(v[i][j]) + roomArea.get(v[nr][nc]);
                twoSum = Math.max(sum, twoSum);
            }
        }

    }

}
