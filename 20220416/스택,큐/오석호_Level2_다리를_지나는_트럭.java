import java.io.*;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Integer> q = new LinkedList<>(); // 진입한 트럭의 인덱스
        Queue<Integer> q_pop = new LinkedList<>(); // 트럭 통과시간 큐
        int w = truck_weights[0]; // 현재 올라가있는 트럭의 무게
        int idx = 1; // 현재 인덱스
        q.add(0); // 첫 트럭 들어간거 넣어줌
        q_pop.add(bridge_length); // 첫 트럭이 통과하는 시간 넣어줌
        
        while(!q.isEmpty() && w != 0){
            // 트럭이 더 못들어가거나, 모든 트럭이 입장했다면 시간 넘겨버리기
            if (idx != truck_weights.length && weight - w < truck_weights[idx] || idx == truck_weights.length) {
                answer = q_pop.peek(); 
            }
            // 도착 확인
            if (q_pop.peek() == answer) {
                q_pop.poll();
                w -= truck_weights[q.peek()];
                q.poll();
            }
            // 입장 확인
            if(idx != truck_weights.length && weight - w >= truck_weights[idx]){
                q.add(idx);
                q_pop.add(answer + bridge_length);
                w += truck_weights[idx];
                ++idx;
            }
            System.out.println(answer);
            ++answer; // 한번에 여러 트럭이 동시에 올라갈 수 없으니까 1초씩 증가
        }
        
        return answer;
    }
}
