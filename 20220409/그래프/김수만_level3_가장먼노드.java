import java.util.*;

//dijkstra 이용
class Solution {
    private class Node implements Comparable<Node>{
        int num, dis;
        
        Node(int num, int dis){
            this.num = num;
            this.dis = dis;
        }
        
        public int compareTo(Node o){
            return Integer.compare(this.dis, o.dis);
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[][] adj = new int[edge.length*2][2];
        for(int i=0; i<edge.length; i++){
            adj[i*2][0] = edge[i][0];
            adj[i*2][1] = edge[i][1];
            adj[i*2+1][0] = edge[i][1];
            adj[i*2+1][1] = edge[i][0];
        }
        
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] v = new boolean[n+1];
        pq.offer(new Node(1,0));
        dis[1] = 0;
        int max = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(v[node.num]) continue;
            v[node.num] = true;
            max = Math.max(max, node.dis);
            
            for(int[] e : adj){
                if(e[0] == node.num){
                    if(!v[e[1]] && dis[e[1]] > node.dis + 1){
                        dis[e[1]] = node.dis + 1;
                        pq.offer(new Node(e[1],dis[e[1]]));
                    }
                }
            }
        }
        
        for(int i=2; i<=n; i++){
            if(dis[i] == max) answer++;
        }
        return answer;
    }
}
