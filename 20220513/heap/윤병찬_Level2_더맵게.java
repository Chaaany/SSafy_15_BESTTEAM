import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            pq.add((long)scoville[i]);
        }
        
        int cnt = 0;
        while(pq.size() >= 2){
            long firstOne, secondOne;
            firstOne = pq.poll();
            if(firstOne >= K) break;
            
            secondOne = pq.poll();
            pq.add(firstOne + secondOne * 2);
            cnt++;
        }
        if(pq.isEmpty() || pq.poll()<K){
            answer =-1;
        }else {
            answer = cnt;
        }
        
        return answer;    
    }
        
}
