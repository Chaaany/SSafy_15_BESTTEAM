import java.util.*;
import java.io.*;

class Solution
{
    public int solution(int [][] arr)
    {
        int answer = 1;

        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1]!= o2[1]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        int end = arr[0][1];
        for(int i = 0; i < arr.length-1; i++){
            if(end <= arr[i+1][0]){
                end = arr[i+1][1];
                answer++; 
            }
        }
        return answer;
    }
}
