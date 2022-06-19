import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            int from = commands[i][0]-1;
            int to = commands[i][1]-1;
            int index = commands[i][2]-1;
            int arr[] = new int[to - from +1];
            for(int j = 0, k = from; j <  to - from + 1; j++, k++){
                arr[j] = array[k];
            }
     
            Arrays.sort(arr);
            answer[i] = arr[index];
        }

        return answer;
    }
}
