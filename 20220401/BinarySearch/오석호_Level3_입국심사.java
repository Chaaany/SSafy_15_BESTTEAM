import java.util.*;

class Solution {
    long max;
    long min;
    long mid;
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        max = (long)n * (long)1000000000; // 길어봐야~ 이것보다는 짧다~
        min = 1;
        while(max >= min) {
            long cnt = 0;
            mid = (max + min) / 2;
            for (int i = 0; i < times.length; ++i){
                cnt += mid / times[i]; // 잘 나눠서 하면 mid시간에는 cnt까지 가능하네?
            }
            if (n <= cnt) { // 되는경우 answer에 업데이트
                max = mid - 1;
                answer = mid;
            }
            else if (cnt < n) min = mid + 1;
        }
        return answer;
    }
}
