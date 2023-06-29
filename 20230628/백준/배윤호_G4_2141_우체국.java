import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<town> pq = new PriorityQueue<>();
        long left = 0;
        long right = 0;
        long minPos = 0;
        long beforePos = -100000000;
        long sumDistance = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int peo = Integer.parseInt(st.nextToken());
            pq.add(new town(pos, peo));
            right += peo;
        }
        while (!pq.isEmpty()) {
            town t = pq.poll();
            long curPos = t.pos;
            long curPeo = t.peo;
            sumDistance += left - right;
            if (sumDistance < min) {
                minPos = curPos;
                min = sumDistance;
            }
            left += curPeo;
            right -= curPeo;
            beforePos = curPos;
        }
        System.out.println(minPos);
    }

    public static class town implements Comparable<town> {
        long pos;
        long peo;

        town(long pos, long peo) {
            this.pos = pos;
            this.peo = peo;
        }

        @Override
        public int compareTo(town t) {
            return (int) (this.pos - t.pos);
        }
    }

}
