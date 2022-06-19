import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int locationpr) {
        int answer = 0;
        Queue<Integer> p = new LinkedList<>();
        Queue<Integer> items = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; ++i){
            p.add(priorities[i]);
            items.add(i);
            pq.add(priorities[i]);
        }
        
        while(!p.isEmpty()){
            int tmp1 = p.poll();
            int tmp2 = items.poll();
            int tmp3 = pq.poll();
            if (tmp1 == tmp3) {
                ++answer;
                if (tmp2 == locationpr) break;
            }
            else {
                p.add(tmp1);
                items.add(tmp2);
                pq.add(tmp3);
            }
        }
        return answer;
    }
}
