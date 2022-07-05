import java.util.*;
class Solution {
    static ArrayList<Integer> list = new ArrayList<>();
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        int[] choice = new int[2];
        combi(0,0,numbers, choice);
        
        Collections.sort(list);
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void combi(int start, int cnt, int[] nums, int[] choice) {
        if(cnt==2) {
            int sum = choice[0] + choice[1];
            if(!list.contains(sum))
                list.add(sum);
            return;
        }
        for(int i = start; i < nums.length; i++) {
            choice[cnt] = nums[i];
            combi(i+1, cnt+1, nums, choice);
        }
    }
}
