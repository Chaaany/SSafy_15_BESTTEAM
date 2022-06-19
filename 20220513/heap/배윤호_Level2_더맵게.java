import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        while(pq.peek()<K){
            if(pq.size()==1){
                answer=-1;
                break;
            }
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a+b*2);
            System.out.println(pq);
            answer++;
        }
        
        return answer;
    }
}
