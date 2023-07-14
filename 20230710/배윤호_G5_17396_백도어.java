import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] v = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }
        v[N - 1] = 0;

        ArrayList<Load>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<Load>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Long t = Long.parseLong(st.nextToken());
            if (v[a] == 1 || v[b] == 1)
                continue;
            graph[a].add(new Load(b, t));
            graph[b].add(new Load(a, t));
        }
        Long[] dist = new Long[N];
        for (int i = 0; i < N; i++) {
            dist[i] = Long.MAX_VALUE;
        }

        PriorityQueue<Load> pq = new PriorityQueue<>();
        pq.add(new Load(0, 0l));
        dist[0] = 0l;
        // go:
        while (!pq.isEmpty()) {
            Load cur = pq.poll();
            if (dist[cur.index] < cur.cost)
                continue;
            for (int i = 0; i < graph[cur.index].size(); i++) {
                Load next = graph[cur.index].get(i);
                if (dist[next.index] > cur.cost + next.cost) {
                    dist[next.index] = cur.cost + next.cost;
                    pq.add(new Load(next.index, dist[next.index]));
                    // if(next.index==N-1) break go;
                }
            }
        }
        if (dist[N - 1] == Long.MAX_VALUE)
            dist[N - 1] = -1l;
        System.out.println(dist[N - 1]);
    }

    public static class Load implements Comparable<Load> {
        int index;
        Long cost;

        Load(int index, Long cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Load l) {
            if (this.cost > l.cost) {
                return 1;
            }
            return -1;
        }
    }

}
