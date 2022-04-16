import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            q.add(i);
        }
        
        Queue<Integer> exit = new LinkedList<>();
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[cur] < priorities[i]) {
                    q.add(cur);
                    break;
                }
                
                if (i == priorities.length-1) {
                    exit.add(cur);
                    priorities[cur] = 0;
                }
            }
            
        }
        
       int answer = 1;
        while(!exit.isEmpty()) {
        	int cur = exit.poll();
        	if (cur == location)
        		break;
        	else
        		answer++;
        }
        
        return answer;
    }
}
