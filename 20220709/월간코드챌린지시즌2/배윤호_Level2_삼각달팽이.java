class Solution {
    static int[] dr = {0,-1,1};
    static int[] dc = {1,-1,0};
    public int[] solution(int n) {
        int m = 0;
        for(int i= 1; i<=n; i++){
            m+=i;
        }
        int[] answer = new int[m];
               
        int[][] map = new int[n][n];
        int number = 1;
        for(int i=0; i<n; i++){
            map[i] = new int[i+1];
            map[i][0] = number++;         
        }
    
        int sr = n-1;
        int sc = 0;
        int d =0;
        int roop = n-1;
        while(roop>0){
            for(int i=0; i<roop; i++){
                sr += dr[d];
                sc += dc[d];
                map[sr][sc]=number++;
            }
            d++;
            if(d==3){
                d=0;
            }
            roop--;       
        }
        int index =0;  
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                answer[index] = map[i][j];
                index++;
            }
        }   
        
        return answer;
    }
}
