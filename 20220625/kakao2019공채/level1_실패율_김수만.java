import java.util.*;

class Solution {
    class Stage implements Comparable<Stage>{
        int num;
        double failRate;
        
        Stage(int num, double failRate){
            this.num = num;
            this.failRate = failRate;
        }
        
        public int compareTo(Stage s){
            if(failRate == s.failRate)
                return Integer.compare(num, s.num);
            return Double.compare(s.failRate, failRate);
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] fail = new double[N+1]; //N번째 스테이지의 실패율
        int[] nums = new int[N+2]; //N번째 스테이지에 있는 사람의 수
        int[] sums = new int[N+1]; //N번째 스테이지에 도전한 사람의 수
        ArrayList<Stage> list =  new ArrayList<>();
        
        for(int i=0; i<stages.length; i++){
            nums[stages[i]]++;
        }
        
        for(int i=1; i<=N; i++){
            for(int j=i; j<=N+1; j++)
                sums[i] += nums[j];
        }
        
        for(int i=1; i<=N; i++){
            if(sums[i] == 0)
                fail[i] = 0;
            else
                fail[i] = (double)nums[i]/sums[i];
            list.add(new Stage(i, fail[i]));
        }
        Collections.sort(list);
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).num;
        }
            
        return answer;
    }
}
