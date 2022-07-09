class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int delta[][] = {{1, 0}, {0, 1}, {-1, -1}};
        
        int[][] tmp = new int[n][n];
            
        int index = 0;
        int r = -1;
        int c = 0;
        int num = 1;
        int m = n;
        while(n-- > 0){
            int tmpIndex = n;
            while(tmpIndex-- >= 0 ){
                r += delta[index][0];
                c += delta[index][1];
                tmp[r][c] = num++;
                
            }
            index = (index+1) % 3;
        }
        
        int idx = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j <= i; j++){
                answer[idx++] = tmp[i][j];
            }
        }
        
        return answer;
    }
}
