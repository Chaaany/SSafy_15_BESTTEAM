class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int size = citations.length;
        for(int i=1; i<size+1; i++){
            int up = 0;
            int down = 0;
            for(int j=0; j<size;j++){
                if(citations[j]>i) up++;
                else if(citations[j]<i) down++;
                else{
                    if(up>=i) down++;
                    else up++;
                }
            }
            if(up>=i&&down<=i){
                answer=Math.max(i,answer);
            }
        }
        
        return answer;
    }
}
