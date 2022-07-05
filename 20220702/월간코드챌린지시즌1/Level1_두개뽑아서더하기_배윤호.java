import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++ ){
                set.add(numbers[i]+numbers[j]);
            }
        }
        int k = 0;
        int[] answer = new int[set.size()];
        for(Integer i: set){
            answer[k++] = i;
        }
        Arrays.sort(answer);
        System.out.println(set);
        
        
        return answer;
    }
}
