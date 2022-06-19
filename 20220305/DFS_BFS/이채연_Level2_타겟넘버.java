class Solution {
    static int N;
    static int answer=0;
    public int solution(int[] numbers, int target) {
        N=numbers.length;
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    public void dfs(int cnt, int sum, int[] numbers, int target){
        if (cnt==N){
            if (sum==target){
                answer++;
            }
            return;
        }
        //-1
        dfs(cnt+1, sum-numbers[cnt], numbers, target);
        //+1
        dfs(cnt+1, sum+numbers[cnt], numbers, target);
    }
}
