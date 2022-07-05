import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        int zero = 0;
        int count = 0;
        
        while(!s.equals("1")) {
            count++;
            
            int one = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='0') 
                    zero++;
                else
                    one++;
            }
            
            s = Integer.toBinaryString(one);
        }
        
        answer = new int[2];
        answer[0] = count;
        answer[1] = zero;
        
        return answer;
    }
}
