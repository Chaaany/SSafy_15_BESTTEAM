import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i =0;
        answer= participant[participant.length-1];
        while (i<completion.length){
        if(!(participant[i].equals(completion[i])))
        {
        answer = participant[i];
        break;
        }
            i++;
        }
        return answer;
    }
}
