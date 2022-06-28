import java.util.*;
class Solution {
    static class Node {
    int idx;
    double rate;
    public Node(int idx, double rate){
        this.idx = idx;
        this.rate = rate;
        }   
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] sum = new int[N+1];
        Arrays.sort(stages);
        int total = stages.length;
        for(int i=0;i<total;i++){
            if(stages[i]<N+1){
                sum[stages[i]]++;
            }           
        }
        ArrayList<Node> list = new ArrayList<>();
        double[] rate = new double[N+1];
        for(int i=1;i<=N;i++){
            if(total==0){
                list.add(new Node(i,0));
                continue;
            }
           rate[i] = (1.0*sum[i])/(1.0 * total);
           total -=sum[i];
            list.add(new Node(i,rate[i]));
        }
        Collections.sort(list,((o1,o2)->Double.compare(o2.rate,o1.rate)));
         for(int i=0;i<N;i++){
           answer[i] = list.get(i).idx;
        }
        return answer;
    }
    
}
