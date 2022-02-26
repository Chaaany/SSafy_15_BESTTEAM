import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int cnt[] = new int[4];
        int[] d2 = {1,3,4,5};
        int[] d3 = {3,1,2,4,5};
        
        for(int i=0; i<answers.length; i++){
            int a1 = i%5+1;
            int a2, a3;
            if(i%2 == 0)
                a2 = 2;
            else{
                int k = (i-1)/2;
                a2 = d2[k%4];
            }
            a3 = d3[(i/2)%5];
            
            if(a1 == answers[i]) cnt[1]++;
            if(a2 == answers[i]) cnt[2]++;
            if(a3 == answers[i]) cnt[3]++;
        }
        
        int max = Math.max(cnt[1], Math.max(cnt[2],cnt[3]));
        for(int i=1; i<=3; i++){
            if(max == cnt[i])
                answer.add(i);
        }
        //높은 점수가 동률일 경우 오름차순 정렬
        if(answer.size() > 1)
            Collections.sort(answer);
        
        //ArrayList를 배열로 변환
        int[] ans = new int[answer.size()];
        int idx = 0;
        for(int i=0; i<answer.size(); i++){
            if(max == cnt[answer.get(i)])
                ans[idx++] = answer.get(i);
        }
        return ans;
    }
}