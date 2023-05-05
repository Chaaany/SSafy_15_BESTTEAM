import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] v = new boolean[101][101];
    static int[] dr = { 0, -1, 0, 1 }; // y축
    static int[] dc = { 1, 0, -1, 0 }; // x축

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragon(x, y, d, g);
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (v[i][j] && v[i + 1][j] && v[i][j + 1] && v[i + 1][j + 1]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dragon(int x, int y, int d, int g) {
        List<Integer> list = new ArrayList<>(); // direction
        list.add(d);
        int index = 0;
        while (g > 0) {
            index = list.size() - 1;
            for (int i = index; i >= 0; i--) {
                int direction = list.get(i);
                switch (direction) {
                    case 0:
                        list.add(1);
                        break;
                    case 1:
                        list.add(2);
                        break;
                    case 2:
                        list.add(3);
                        break;
                    case 3:
                        list.add(0);
                        break;
                }
            }
            g--;
        }
        v[y][x] = true;
        // v[y][x]
        for (int i : list) {
            x += dc[i];
            y += dr[i];
            v[y][x] = true;
        }
    }

}
