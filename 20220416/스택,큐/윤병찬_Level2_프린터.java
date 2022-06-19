import java.io.*;
import java.util.*;


class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 2 1 3 2 A B C D
        // A(2) B(1) C(3) D(2)
        // B(1) C(3) D(2) A(2)
        // C(3) D(2) A(2) B(1)
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            q.add(new int[]{priorities[i], i});
        }
        int printCnt = 0;
        int printIndex = 1011;
        while(location != printIndex){
            int target[] = q.poll();
            boolean chk = false;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int temp[] = q.poll();
                if(chk){
                    q.add(temp);
                }else{
                    if(target[0]<temp[0])chk = true;
                    q.add(temp);
                }
            }
            if(!chk){
                printCnt++;
                printIndex = target[1];
            }else{
                q.add(target);
            }
            System.out.println(printCnt+"번째"+printIndex);
        }
        answer = printCnt;
        return answer;
    }

}
