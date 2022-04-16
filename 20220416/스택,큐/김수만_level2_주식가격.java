import java.util.*;

//이것도 사실 stack 쓸 필요 없습니다...
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int idx = 0;
        for(int i=0; i<prices.length; i++){
            int p = prices[i];
            Stack<Integer> stack = new Stack<>();
            for(int j=i+1; j<prices.length; j++){
                stack.push(prices[j]);
                if(prices[j] < p) break;
            }
            answer[idx++] = stack.size();
        }
        return answer;
    }
}
