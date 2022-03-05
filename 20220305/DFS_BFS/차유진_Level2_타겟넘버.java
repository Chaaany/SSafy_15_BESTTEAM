import java.util.*;
class Solution {
    static int answer = 0;
    static int L;
    public int solution(int[] numbers, int target) {
        L = numbers.length;
        boolean[] sign = new boolean[L];
        for(int i = 0; i < L; i++) {
            sign[i] = false; // true면 양수, false면 음수
        }
        for(int R = 0; R <= L; R++) {
            combi(R, 0, 0, numbers, sign, target);
        }
        return answer;
    }
    
    private void combi(int R, int cnt, int start, int[] nums, boolean[] isPositive, int tg) {
        if(cnt == R) {
            doTheMath(nums, isPositive, tg);
            return;
        }
        for(int i = start; i < L; i++) {
            if(isPositive[i]) continue;
            isPositive[i] = true;
            combi(R, cnt+1, i+1, nums, isPositive, tg);
            isPositive[i] = false;
        }
    }
    private void doTheMath(int[] nums, boolean[] isPositive, int target) {
        int sum = 0;
        for(int i = 0; i < L; i++) {
            if(isPositive[i]) {
                sum+=nums[i];
            } else {
                sum-=nums[i];
            }
        }
        if(sum==target) { 
            answer++;
        }
    }
}
