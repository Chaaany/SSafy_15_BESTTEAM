class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int i = 0;
        while(true) {
            i++;
            int h = i;
            int w = yellow / i;
            if(h*w != yellow) continue;
            if(h * 2 + w * 2 + 4 == brown) {
                answer[0] = w+2;
                answer[1] = h+2;
                break;
            }
        }
        
        return answer;
    }
}