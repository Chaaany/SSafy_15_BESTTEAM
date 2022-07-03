import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        if(a.length<=2){
            answer = a.length;
            return answer;
        }
        answer = 2;
        
        int[] lMin = new int[a.length];
        int[] rMin = new int[a.length];
        int l = a[0];
        int r = a[a.length - 1];

        for(int i = 1; i < a.length - 1; i++) {
            if(l > a[i]) l = a[i];
            lMin[i] = l;
        }
        
        for(int i = a.length - 2; i > 0; i--) {
            if(r > a[i]) r = a[i];
            rMin[i] = r;
        }
        
        for(int i=1; i<a.length-1 ; i++){
            if(lMin[i]<a[i] && rMin[i]<a[i]){
                continue;
            }
            answer++;
        }
        return answer;
    }
}
