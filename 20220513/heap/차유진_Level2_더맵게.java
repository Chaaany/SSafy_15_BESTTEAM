import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int len = scoville.length;
        int idx = 0;
        Arrays.sort(scoville);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int i = 0; i < len; i++) {
            heap.offer(scoville[i]);
        }
        
        while(true) {
            if(heap.size() == 1) {
                answer = -1;
                break;
            }
            heap.offer(heap.poll() +heap.poll() * 2);
            answer++;
            if(heap.peek() >= K) break;
        }
        return answer;
    }
}
