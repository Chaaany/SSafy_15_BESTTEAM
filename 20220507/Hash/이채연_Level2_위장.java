import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map=new HashMap<>();
        for (int i=0; i<clothes.length; i++){
            int cnt= map.containsKey(clothes[i][1]) ? map.get(clothes[i][1]): 0;
            map.put(clothes[i][1], cnt+1);
        }
        for (String kind : map.keySet()){
            answer*=(map.get(kind)+1);
        }
        return answer-1;
    }
}
