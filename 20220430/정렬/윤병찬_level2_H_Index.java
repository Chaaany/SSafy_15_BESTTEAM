import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i = 0;i <= 1000; i++){
            int cnt = 0;
            for(int j = 0; j < citations.length;j++){
                if(citations[j] >= i)cnt++;
            }
            if(i <= cnt)answer = Math.max(answer, i);
        }
        
        return answer;
    }
}
