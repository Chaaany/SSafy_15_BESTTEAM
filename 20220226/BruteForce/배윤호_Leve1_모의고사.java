class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] st1 = {1,2,3,4,5};
        int[] st2 = {2,1,2,3,2,4,2,5};
        int[] st3 = {3,3,1,1,2,2,4,4,5,5};
        int st1point = 0;
        int st2point = 0;
        int st3point = 0;
        int d = 0;
        for(int i =0; i< answers.length; i++){
            if(answers[i]==st1[d]){
                st1point++;
            }
                d++;
            if(d==5){
                d= 0;
            }
        }
        d =0;
         for(int i =0; i< answers.length; i++){
            if(answers[i]==st2[d]){
                st2point++;
            }
                d++;
            if(d==8){
                d= 0;
            }
        }
        d =0;
         for(int i =0; i< answers.length; i++){
            if(answers[i]==st3[d]){
                st3point++;
            }
                d++;
            if(d==10){
                d= 0;
            }
        }
        int max = Math.max(st1point, st2point);
        max = Math.max(max,st3point);
        int index = 0;
        if(max==st1point) index++;
        if(max==st2point) index++;
        if(max==st3point) index++;
        answer = new int[index];
        index = 0;


        if(st1point==max){
            answer[index] = 1;
            index++;
        }
        if(st2point==max){
            answer[index] = 2;
            index++;
        }
        if(st3point==max){
            answer[index]=3;
            index++;
        }



        return answer;
    }
}
