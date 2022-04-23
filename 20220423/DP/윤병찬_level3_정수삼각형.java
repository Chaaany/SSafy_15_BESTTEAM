class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int colLen = triangle[len-1].length;
        int dp[][] = new int[len][colLen];
        // n번쨰의 최댓값 = n-1번째의 최댓값 
        for(int i = 0; i < triangle[len-1].length; i++){
            dp[len-1][i] = triangle[len-1][i];
        }
        for(int i = len-2; i >= 0; i--){
            for(int j = 0; j < triangle[i].length; j++){
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1])+triangle[i][j];
            }
        }
        answer = dp[0][0];
        return answer;
    }
}
