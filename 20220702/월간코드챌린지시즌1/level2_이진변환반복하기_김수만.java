import java.util.*;

class Solution {
    public int[] solution(String s) {
        int loop = 0, cnt = 0;
        while(!s.equals("1")){
            int zeros = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0') zeros++;
            }
            int ones = s.length() - zeros; //1의 개수
            s = "";
            while(ones > 0){
                int rem = ones%2;
                ones /= 2;
                s = rem + s;
            }
            loop++;
            cnt += zeros;
        }
         int[] answer = {loop, cnt};
        return answer;
    }
}
