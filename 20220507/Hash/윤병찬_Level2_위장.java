import java.io.*;
import java.util.*;

class Solution {
    static int arr[], nums[], sumV;
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            if(hm.get(clothes[i][1]) != null){
                hm.put(clothes[i][1], hm.get(clothes[i][1])+1);
            }else {
                hm.put(clothes[i][1], 1);
            }
        }
        
        int size = hm.size();           
        arr = new int[size];
        int index = 0;
            
        for ( String key : hm.keySet() ) {
            answer *= hm.get(key)+1;
        }
        answer -= 1;
        return answer;
    }
  
}
