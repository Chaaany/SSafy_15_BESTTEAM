import java.io.*;
import java.util.*;

class Solution {
    public LinkedList<Integer> solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> answer = new LinkedList<>();
        int idx = 0;
        
        while (idx < speeds.length) {
            int cnt = 0;
            for (int i = idx; i < speeds.length; ++i) progresses[i] += speeds[i];
            while (idx < speeds.length && progresses[idx] >= 100){
                ++cnt;
                ++idx;
            }
            if (cnt > 0) answer.add(cnt);
        }
        
        return answer;
    }
}
