import java.util.*;
public class 이홍주_level2_더맵게 {
	public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<scoville.length;i++){
            pq.add(scoville[i]);
        }
       
        while(true){
            int first =0, second=0;
            if(!pq.isEmpty()) first = pq.poll();
            if(!pq.isEmpty()) second = pq.poll();  
           
            if(first>=K) break;
            else{
                answer++;                
                pq.add(first+second*2);
            }
            if(pq.size()==1 && pq.peek()<K){
                answer=-1;
                break;
            }
        }
        
        return answer;
    }
}
