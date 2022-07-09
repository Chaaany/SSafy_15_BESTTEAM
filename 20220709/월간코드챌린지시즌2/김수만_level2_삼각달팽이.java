class Solution {
    
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] tri = new int[n+1][];
        
        for(int i=1; i<=n; i++){
            tri[i] = new int[i*(i+1)/2];
            int idx = 0, cidx = 0;
            tri[i][idx++] = 1;
            if(i == 1) continue;
            
            for(int j=2; j<i; j++){ //층
                tri[i][idx++] = j;
                for(int k=0; k<j-2; k++){
                    tri[i][idx++] = tri[i-3][cidx++] + 3*i-3;
                }
                tri[i][idx++] = 3*i-1-j;
            }
            
            //마지막 층
            for(int j=i; j<2*i; j++){
                tri[i][idx++] = j;
            }
            
        }
        
        for(int i=0; i<tri[n].length; i++){
            answer[i] = tri[n][i];
        }
        return answer;
    }
    
}
