import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] b = new int[a.length];
        boolean[] v = new boolean[a.length];
        for(int i=0; i<a.length; i++){
            b[a[i]]++;
        }
        
        for(int i=0; i<b.length; i++){
            if(b[i]==0) continue;
            int temp = i;
            if(b[i]*2<=answer) continue;
            int maxanswer = 0;
            v = new boolean[a.length];
            for(int j=0; j<a.length; j++){
                if(v[j]) continue;
                if(a[j]==temp){
                    if(j-1>=0 && a[j] != a[j-1] && v[j-1]==false){
                        v[j] = true;
                        v[j-1] = true;
                        maxanswer+=2;
                    }
                    else if(j+1<a.length && a[j] != a[j+1] && v[j+1]==false){
                        v[j] = true;
                        v[j+1] = true;
                        maxanswer+=2;
                    }
                }
            }
            answer = Math.max(answer,maxanswer);
        }                 

        return answer;
    }
}
