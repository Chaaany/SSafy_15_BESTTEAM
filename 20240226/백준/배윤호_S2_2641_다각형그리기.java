import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = { 0, 0, -1, 0, 1 };
    static int[] dc = { 0, 1, 0, -1, 0 };
    static boolean[][] v;
    static boolean[][] v2;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        v = new boolean[100][100];
        int cr = 50;
        int cc = 50;
        int minR = 50;
        int minC = 50;
        v[cr][cc] = true;
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int dir = Integer.parseInt(st.nextToken());
            arr[i] = dir;
            cr += dr[dir];
            cc += dc[dir];
            minR = Math.min(minR, cr);
            minC = Math.min(minC, cc);
        }
        cr = 50 - minR;
        cc = 50 - minC;
        for (int i = 0; i < N; i++) {
            int dir = arr[i];
            cr += dr[dir];
            cc += dc[dir];
            v[cr][cc] = true;
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            StringBuilder sb2 = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            cr = 50;
            cc = 50;
            minR = 50;
            minC = 50;
            boolean same = true;
            for (int j = 0; j < N; j++) {
                int dir = Integer.parseInt(st.nextToken());
                arr[j] = dir;
                cr += dr[dir];
                cc += dc[dir];
                minR = Math.min(minR, cr);
                minC = Math.min(minC, cc);
            }
            cr = 50 - minR;
            cc = 50 - minC;
            boolean[][] v2 = new boolean[100][100];
            for (int j = 0; j < N; j++) {
                int dir = arr[j];
                cr += dr[dir];
                cc += dc[dir];
                sb2.append(dir + " ");
                if (!v[cr][cc] || v2[cr][cc]) {
                    same = false;
                    break;
                }
                v2[cr][cc] = true;
            }
            if (same) {
                cnt++;
                sb2.append("\n");
                sb.append(sb2);
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }

}
