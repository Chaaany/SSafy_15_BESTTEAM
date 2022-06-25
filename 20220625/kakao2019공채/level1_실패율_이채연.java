import java.util.*;

class Solution {
    static class FailRate implements Comparable<FailRate>{
        int num;
        double rate;
        FailRate(int num, double rate){
            this.num=num;
            this.rate=rate;
        }
        @Override
        public int compareTo(FailRate o){
            if (o.rate==this.rate){
                return this.num-o.num;
            }
            return Double.compare(o.rate,this.rate);
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] cnt=new int[N+2];
        ArrayList<FailRate> temp=new ArrayList<>();
        for (int i=0; i<stages.length; i++){
            cnt[stages[i]]+=1;
        }
        for (int i=1; i<=N; i++){
            int sum=0;
            for (int j=i; j<=N+1; j++){
               sum+=cnt[j]; 
            }
            if (sum==0) temp.add(new FailRate(i, 0));
            else temp.add(new FailRate(i, (double)cnt[i]/sum));
        }
        Collections.sort(temp);
        for (int i=0; i<temp.size(); i++){
            answer[i]=temp.get(i).num;
        }
        return answer;
    }
}
