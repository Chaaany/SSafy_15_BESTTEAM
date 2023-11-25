import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Pic[] Pics = new Pic[N];
        int[] index = new int[101];
        Arrays.fill(index, -1);
        int M = Integer.parseInt(br.readLine());
        int time = 0;
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Pics[i] = new Pic(0, 0, 0);
        }
        for (int i = 0; i < M; i++) {
            Arrays.sort(Pics);
            for (int j = 0; j < N; j++) {
                Pic p = Pics[j];
                index[p.num] = j;
            }
            time++;
            int cur = Integer.parseInt(st.nextToken());
            // System.out.println("zzzzzzzzz");

            // for(Pic p: Pics){
            // System.out.println(p.num+" "+p.rec+" "+p.time);

            // }
            if (index[cur] != -1) {
                Pic p = Pics[index[cur]];
                Pics[index[cur]] = new Pic(cur, p.rec + 1, p.time);
            } else {
                if (count < N) {
                    index[cur] = count;
                    Pics[0] = new Pic(cur, 1, time);
                    count++;
                } else {
                    Pic p = Pics[0];
                    index[p.num] = -1;
                    Pics[0] = new Pic(cur, 1, time);
                    index[cur] = 0;
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Pic p : Pics) {
            pq.add(p.num);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            if (temp == 0)
                continue;
            sb.append(temp + " ");
        }
        System.out.println(sb);
    }

    static class Pic implements Comparable<Pic> {
        int num;
        int rec;
        int time;

        Pic(int num, int rec, int time) {
            this.num = num;
            this.rec = rec;
            this.time = time;
        }

        @Override
        public int compareTo(Pic o) {
            if (this.rec != o.rec) {
                return this.rec - o.rec;
            } else {
                return this.time - o.time;
            }
        }
    }
}
