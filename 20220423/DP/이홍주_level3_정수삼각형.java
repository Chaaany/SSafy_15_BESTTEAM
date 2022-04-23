class 이홍주_level3_정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int N  = triangle.length;
        int M = triangle[triangle.length-1].length;
        int[][] D = new int[N][M];
        D[0][0] = triangle[0][0];
        for(int i = 1; i < N ;i++){
            for(int j = 0; j <= i ;j++ ){
                if(j==0){
                    D[i][0] = D[i-1][0]+triangle[i][0];
                }
                else if(j==i){
                     D[i][j] = D[i-1][j-1]+triangle[i][j];
                }
                else{
                    D[i][j] = Math.max(D[i-1][j-1],D[i-1][j])+triangle[i][j];
                }
            }
        }
       for(int i = 0; i < M ;i++){
           answer = Math.max(answer,D[N-1][i]);
       }
        return answer;
    }
}