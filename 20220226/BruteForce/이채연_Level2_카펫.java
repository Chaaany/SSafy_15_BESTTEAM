class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total=brown+yellow;
        int y=1, x=total; //x*y=brown+yellow, (x-2)*(y-2)=yellow
        while (x>=y){       //조건에 맞는 x, y를 찾아준다 (y 증가시켜 가면서)
            if (total%y==0){
                x=total/y;
                if ((x-2)*(y-2)==yellow) break;
            }
            y++;
        }
        answer[0]=x;
        answer[1]=y;
        return answer;
    }
}
