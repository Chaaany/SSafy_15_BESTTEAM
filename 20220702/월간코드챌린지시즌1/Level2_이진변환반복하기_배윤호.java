import java.util.*;
import java.io.*;

class Solution {
    //static int count = 0;
    //static int dzero = 0;
    public int[] solution(String s) {
        int count = 0;
        int dzero = 0;
        int l = 0;
      while(!s.equals("1")){
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='0'){
                    dzero++;
                }
            }
            s = s.replace("0","");
            l = s.length();
            s = Integer.toBinaryString(l);
            count++;
        }
        System.out.println(s);
        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = dzero;
        return answer;
    }
}
