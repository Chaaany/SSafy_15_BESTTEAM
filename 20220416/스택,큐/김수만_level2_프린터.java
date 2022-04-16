import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int size = priorities.length;
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<size; i++){
            q.add(priorities[i]);
        }
        
        while(!q.isEmpty()){
            int val = q.poll();
            int max = 0;
            Queue<Integer> tmp = new LinkedList<>(q);
            while(!tmp.isEmpty()){
                int v = tmp.poll();
                max = Math.max(max, v);
            }
            
            //자신보다 큰 값이 있으면 q 뒤에 넣기
            if(max > val){
                q.offer(val);
            }
            else{ //자신보다 큰 값이 없으면 그대로 poll, 순서 증가
                answer++;
                if(location == 0) break;
            }
            location--;
            if(location < 0) location = q.size()-1;
        }
        return answer;
    }
}
