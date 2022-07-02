import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer;
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(i == j) continue;
                set.add(numbers[i]+numbers[j]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : set)
            list.add(i);
        Collections.sort(list);
        
        answer = new int[list.size()];
        int idx = 0;
        for(int i : list)
            answer[idx++] = i;
        return answer;
    }
}
