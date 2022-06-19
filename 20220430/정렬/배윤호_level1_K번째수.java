import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] temp;
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int size = commands[i][1]-commands[i][0];
            temp = new int[size+1];
            int index = 0;
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                temp[index]= array[j];
                index++;
            }
            Arrays.sort(temp);
            answer[i]=temp[commands[i][2]-1];
        }
        
        return answer;
    }
}
