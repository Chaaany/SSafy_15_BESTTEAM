import java.util.*;

class Solution {
    static class Node{
        String s;
        int cnt;
        Node(String s, int cnt){
            this.s=s;
            this.cnt=cnt;
        }
    }
    static boolean[] visited;
    static int answer=0;
    public int solution(String begin, String target, String[] words) {
        visited=new boolean[words.length];
        bfs(begin, target, words);
        return answer;
    }
    public void bfs(String begin, String target, String[] words){
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(begin, 0));
        while (!q.isEmpty()){
            Node curr=q.poll();
            if (curr.s.equals(target)){         //목적지에 도착하면 answer 갱신 후 탐색 종료
                answer=curr.cnt;
                return;
            }
            for (int i=0; i<words.length; i++){
                if (!visited[i] && isNeighbor(curr.s, words[i])){   //미방문, 이웃이면 탐색 큐에 넣어줌
                    visited[i]=true;
                    q.add(new Node(words[i], curr.cnt+1));
                }
            }
        }
    }
    public boolean isNeighbor(String a, String b){     //한글자만 달라야 이웃
        int diff=0;
        for (int i=0; i<a.length(); i++){
            if (a.charAt(i)!=b.charAt(i)) diff++;
        }
        if (diff==1) return true;
        else return false;
    }
}
