import java.util.*;

//굳이 스택을 안써도 되네요
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int size = progresses.length;
        int[] answer = new int[size];
        Stack<Integer> stack = new Stack<>();
        
        int idx = 0;
        int a = 0;
        while(a < size){
            for(int i=a; i<size; i++)
                progresses[i] += speeds[i];
            
            for(int i=a; i<size; i++){
                if(progresses[i] >= 100){
                    stack.add(i);
                    a++;
                }
                else break;
            }
            
            if(stack.size() > 0){
                answer[idx++] = stack.size();
                stack = new Stack<>(); //스택 비우기
            }
        }
        
        for(int i=0; i<size; i++){
            if(answer[i] == 0){ 
                idx = i;
                break;
            }
        }
        int[] res = Arrays.copyOf(answer, idx);
        return res;
    }
}
