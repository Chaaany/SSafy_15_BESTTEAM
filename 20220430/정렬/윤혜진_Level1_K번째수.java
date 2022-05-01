import java.util.*;
    
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
                
        int idx = 0;
        for(int[] c: commands) {
            int[] s = Arrays.copyOfRange(array, c[0]-1, c[1]);
            Arrays.sort(s);
            answer[idx] = s[c[2]-1];
            idx++;
        }
        
        return answer;
    }
}
