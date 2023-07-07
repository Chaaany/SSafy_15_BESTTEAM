import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if (M == 0) {
            System.out.println(N);
            return;
        }
        PriorityQueue<moving> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new moving(x, y));
        }
        int room = 1;
        moving first = pq.poll();
        int bx = first.x;
        int by = first.y;
        room += bx - 1;
        M--;
        while (M > 0) {
            moving cur = pq.poll();
            int cx = cur.x;
            int cy = cur.y;
            if (cx > by) {
                room += cx - by;
                bx = cx;
                by = cy;
            } else if (cx == by) {
                by = cy;
            } else {
                if (cy > by) {
                    by = cy;
                }
            }
            M--;
        }
        room += N - by;
        System.out.println(room);

    }

    public static class moving implements Comparable<moving> {
        int x;
        int y;

        moving(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(moving m) {
            if (m.x == this.x) {
                return this.y - m.y;
            }
            return this.x - m.x;
        }
    }

}
