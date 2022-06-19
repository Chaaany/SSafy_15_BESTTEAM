import java.lang.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> m = new HashMap<>();
        for (int i = 0; i < clothes.length; ++i){
            int count = m.containsKey(clothes[i][1]) ? m.get(clothes[i][1]) : 0;
            m.put(clothes[i][1], count+1);
        }
        
        for (String key : m.keySet()) {
            answer *= (m.get(key) + 1);
        }
        
        // 최소 하나는 입어야 하므로 1 빼기
        return --answer;
    }
}
