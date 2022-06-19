import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer; 
        int val=-1, num=0;
        int N=progresses.length;
        Queue<Integer> times=new LinkedList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        for (int i=0; i<N; i++){            //작업 끝나기까지 걸리는 시간 계산
            int a=(100-progresses[i])/speeds[i];
            int b=(100-progresses[i])%speeds[i];
            if (b>0) a++;
            times.offer(a);
        }
        while (!times.isEmpty()){   
            int now=times.poll();
            if (val<now){               //현재 작업 시간보다 큰 값이 나오면
                if (val>0) temp.add(num);   //기존에 저장된 작업들 갯수 answer에 넣어주고
                val=now;        //작업 시간 갱신 
                num=1;
            }
            else{       //현재 작업 시간보다 작거나 같은 값 나오면
                num++;      //작업 갯수 증가
            }   
        }
        if (val>0) temp.add(num);
        answer=new int[temp.size()];
        for (int i=0; i<temp.size(); i++){
            answer[i]=temp.get(i);
        }
        return answer;
    }
}
