import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int i=0; i<commands.length; i++){
            int[] arr = new int[commands[i][1]-commands[i][0]+1];
            int a = 0;
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                arr[a++] = array[j];
            }
            Arrays.sort(arr);
            answer[idx++] = arr[commands[i][2]-1];
        }
        return answer;
    }
}
