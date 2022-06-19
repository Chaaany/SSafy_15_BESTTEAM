import java.util.*;

class Solution {
    
    int[] Numbers;
    int T, ans;
    
    public int solution(int[] numbers, int target) {
        Numbers = numbers;
        T = target;
        dfs(0,0);
        return ans;
    }
    
    private void dfs(int idx, int total){
        if(idx == Numbers.length){
            if(total == T) ans++;
            return;
        }
        
        dfs(idx+1, total+Numbers[idx]);
        dfs(idx+1, total-Numbers[idx]);
    }
}