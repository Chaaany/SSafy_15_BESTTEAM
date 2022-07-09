class Solution {
    public int[] solution(int n) {
        int[][] snail = new int[n][n];
        int[] dr = {1,0,-1};
        int[] dc = {0,1,-1};       
        int r =0;
        int c = 0;
        int d =0;
        int total = 0;
        for(int i=1;i<=n;i++){
            total +=i;
        }
         int[] answer = new int[total];
        for(int i=1;i<=total;i++){
            snail[r][c]=i;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr<0 || nc<0 || nr>n-1 || nc>n-1||snail[nr][nc]!=0) {
                d = (d+1)%3;
                nr = r + dr[d];
                nc = c + dc[d];
            }
            r = nr;
            c = nc;
        }
        int idx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(snail[i][j]==0)break;
                answer[idx++]=snail[i][j];
            }
        }
        return answer;
    }
}
