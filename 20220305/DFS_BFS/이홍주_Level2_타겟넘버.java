class 이홍주_Level2_타겟넘버 {
    static int N, sum, answer;

    public int solution(int[] numbers, int target) {
        answer = 0;
        N = numbers.length;

        dfs(numbers, target,0, numbers[0]);
        dfs(numbers, target,0, -1*numbers[0]);
        return answer;
    }
    static public void dfs(int[] numbers, int target, int cnt,int total){
        if(cnt==N-1){
            if(total==target) answer++;
            return;
        }        
        dfs(numbers,target,cnt+1,total+numbers[cnt+1]);       
        dfs(numbers,target,cnt+1, total-numbers[cnt+1]);
    }
}