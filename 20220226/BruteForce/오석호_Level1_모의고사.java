class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        int firstCnt = 0;
        int secondCnt = 0;
        int thirdCnt = 0;
        int max = -1;
        int maxCnt = 0;
        
        for (int i = 0; i < answers.length; ++i) {
            if (first[i % 5] == answers[i]) firstCnt++;
            if (second[i % 8] == answers[i]) secondCnt++;
            if (third[i % 10] == answers[i]) thirdCnt++;
        }
        
        max = Math.max(Math.max(firstCnt, secondCnt), thirdCnt);
        
        if (firstCnt == max) maxCnt++;
        if (secondCnt == max) maxCnt++;
        if (thirdCnt == max) maxCnt++;
        
        int[] answer = new int[maxCnt];
        int tmp = 0;
        if (firstCnt == max) {
            answer[tmp] = 1;
            tmp++;
        }
        
        if (secondCnt == max) {
            answer[tmp] = 2;
            tmp++;
        }
        
        if (thirdCnt == max) {
            answer[tmp] = 3;
            tmp++;
        }
        
        return answer;
    }
}
