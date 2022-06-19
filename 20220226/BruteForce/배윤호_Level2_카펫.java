class Solution {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int xPy = (brown+4)/2;
        int x = 3;
        int y = xPy-3;
        while(true) {
            if((x-2)*(y-2)==yellow) {
                break;
            }
            else {
                x++;
                y--;
            }
        }
        answer[0] = Math.max(x,y);
        answer[1] = Math.min(x,y);
        return answer;
    }
}
