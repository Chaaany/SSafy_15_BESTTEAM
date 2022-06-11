import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // participant와 completion 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        // 인덱스를 앞으로 진행하면서 비교
        int chk = completion.length;
        for (int i = 0; i < completion.length; ++i) {
            if (!participant[i].equals(completion[i])) {
                chk = i;
                break;
            }
        }
        answer = participant[chk];
        
        return answer;
    }
}
