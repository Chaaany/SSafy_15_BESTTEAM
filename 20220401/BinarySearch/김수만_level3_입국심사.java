class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 1, end = Integer.MAX_VALUE;
        for(int i=0; i<times.length; i++)
            end = Math.min(end, (long)times[i]);
        end *= (long)n;
        
        while(start <= end){
            long mid = (start+end)/2;
            long num = 0;
            for(int t : times){
                num += mid/(long)t;
            }
            
            if(num >= n){
                answer = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return answer;
    }
}
