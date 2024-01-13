import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N;
    static long C;
    static HashMap<Long, Integer> map; // number, cnt
    static HashMap<Long, Integer> map_idx; // number, cnt
    static PriorityQueue<Number> pq;
    static class Number implements Comparable<Number>{
        long number;
        int idx;
        int cnt;
        public Number(long number, int idx, int cnt){
            this.number = number;
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Number n){
            if(this.cnt==n.cnt) return this.idx-n.idx;
            else return n.cnt-this.cnt;
        }
    }
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());
       
        map = new HashMap<>();
        map_idx = new HashMap<>();

        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Long tmp = Long.parseLong(st.nextToken());

            if(!map.containsKey(tmp)){
                map_idx.put(tmp,i);
            }
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
            
        }
        
        pq = new PriorityQueue<>();

        map.forEach((k,v)->{
            pq.add(new Number(k, map_idx.get(k), map.get(k)));
        });
       
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Number now = pq.poll();
            for(int i=0;i<now.cnt;i++){
                sb.append(now.number+" ");
            }
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
        
    }
}
