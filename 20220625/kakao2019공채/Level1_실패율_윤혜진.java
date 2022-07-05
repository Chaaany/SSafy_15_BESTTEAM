import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        Arrays.sort(stages);
        double[] nums = new double[N+1];
        
        for(int i = 0; i < stages.length; i++) {
            if(stages[i] > N) continue;
            nums[stages[i]]++;
        }
        
        int allCnt = stages.length;
        int stageCnt = 0;
        double[] failRate = new double[N+1];
       
        for(int i = 1; i < nums.length; i++) {
            double num = nums[i];
            if(num==0) {
                failRate[i] = 0;
            }
            else {
                failRate[i] = (double)num/(double)allCnt;
                nums[i] = (double)num/(double)allCnt;
                allCnt -= num;
            }
        }
        
        Arrays.sort(failRate);     
        
        int idx = N-1;
        for(int i = 1; i < failRate.length; i++) {          
            for(int j = failRate.length-1; j > 0; j--) {
                if(failRate[i] == nums[j]) {
                    nums[j] = -1;
                    answer[idx--] = j;
                }
            }
        }
        
        return answer;
    }
}
