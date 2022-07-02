import java.util.*;
 
class Solution {
    static int[] res;
    static HashSet<Integer> set;
    public int[] solution(int[] numbers) {
       
        res = new int[2];
        set = new HashSet<Integer>();
        combi(numbers,0,0);
        int[] answer = new int[set.size()];
        int idx=0;
         for(int i : set){
           answer[idx++] = i;
        }
        Arrays.sort(answer);
        return answer;
    }
    public void combi(int[] numbers,int  cnt,int start){
        if(cnt==2){
            int sum = res[0] + res[1];
            set.add(sum);
            return;
        }
        for(int i=start;i<numbers.length;i++){
            res[cnt] = numbers[i];
            combi(numbers,cnt+1,i+1);
        }
    }
}
