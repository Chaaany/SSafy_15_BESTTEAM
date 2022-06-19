import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int[] tempAnswer = new int[101];
        int[] temp = new int[progresses.length];
        // 앞 부분 보다 먼저 끝나면 앞 부분이랑 같이 배포
        // 다르게 끝나면 따로 배포
        // 5 10 1 1 20 1
        // 5 10 10 10 20 20
        
        Queue<Integer> q = new LinkedList<>();
        int idx = 1;
        for(int i = 0; i < progresses.length; i++){
            temp[i] = (int)Math.ceil(((double)100-progresses[i])/speeds[i]);
            
            if(i != 0 && temp[i-1] >= temp[i]){
                temp[i] = temp[i-1];               
            }
            tempAnswer[temp[i]]++;
        }
        
        for(int i = 0; i < 101; i++){
            if(tempAnswer[i] != 0)
                q.add(tempAnswer[i]);
        }
        
        answer = new int[q.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = q.poll();
        }
        
        return answer;
    }
}
