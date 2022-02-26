class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //(r-2)*(c-2) == yellow
        //r*c == brown + yellow
        
        int idx = 0;
        for(int i=3; i<=(int)Math.sqrt(brown+yellow); i++){
            for(int j=i; j<=brown+yellow; j++){
                if((i*j == brown + yellow) && ((i-2)*(j-2) == yellow)){
                    answer[idx++] = j;
                    answer[idx] = i;
                    return answer;
                }
            }
        }
        
        System.out.println("Fail");
        return answer;
    }
}