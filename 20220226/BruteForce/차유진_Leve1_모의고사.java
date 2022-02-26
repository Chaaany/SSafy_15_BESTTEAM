import java.util.*;
class Solution {
    static int[] a = {1,2,3,4,5};
    static int[] b = {2,1,2,3,2,4,2,5};
    static int[] c = {3,3,1,1,2,2,4,4,5,5};
    public int[] solution(int[] answers) {
        int as = checkAnswer(answers, a);
        int bs = checkAnswer(answers, b);
        int cs = checkAnswer(answers, c);
        if(as == bs && bs == cs) {
            return new int[] {1,2,3};
        } else if(as == bs && bs > cs) {
            return new int[] {1,2};
        } else if(as == cs && as > bs) {
            return new int[] {1,3};
        } else if(bs == cs && bs > as) {
            return new int[] {2,3};
        } else {
            int max = -1;
            max = Math.max(as,bs);
            max = Math.max(max, cs);
            if(max == as) return new int[] {1};
            if(max == bs) return new int[] {2};
            else return new int[] {3};
        }
    }
    private int checkAnswer(int[] ans, int[] person) {
        int score = 0;
        for(int i = 0; i < ans.length; i++) {
            if(ans[i] == person[i%person.length]) score++;
        }
        return score;
    }
}