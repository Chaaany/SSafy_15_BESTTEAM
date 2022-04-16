import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
            days[i] = (int)Math.ceil((double)(100 - progresses[i])/speeds[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < days.length; i++) {
            if(stack.isEmpty() || days[i] > days[stack.peek()]) {
				stack.push(i);
			}
		}
        
        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0 ; i--) {
        	if(i == stack.size() -1 ) {
        		answer[i] = days.length - stack.get(i);
            } else {
                answer[i] = stack.get(i+1) - stack.get(i);
        	}
        }
        return answer;
    }
}
