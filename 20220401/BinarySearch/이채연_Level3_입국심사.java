import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer=0;
        int max=Integer.MIN_VALUE;
        for (int i=0; i<times.length; i++){
            if (max<times[i]) max=times[i];
        }
        long left=1;
        long right=(long)n*(long)max;
        long mid=left; 
        while (left<=right){
            long possible=0;
            mid=(left+right)/2;
            for (int i=0; i<times.length; i++){
                possible+=(mid/times[i]);
            }
            if (possible>=n){   //해당 시간 내에 처리가능한 인원 수가 n명 이상이면 더 시간을 줄여보자
                answer=mid;
                right=mid-1;
            }
            else{       //n명 미만이면 시간을 늘리자
                left=mid+1;
            }
        }
        return answer;
    }
}
