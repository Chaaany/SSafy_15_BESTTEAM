class Solution {
    int chk[]; // 방문 체크용
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        chk = new int[201];
        
        // 앞에서부터 돌면서 dfs로 연결되어있는지 확인
        for (int i = 0; i < n; ++i){
            if (chk[i] == 0){
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    // dfs로 연결되어있으면 체크하고 재귀돌리기
    void dfs(int start, int n, int[][] computers) {
        for (int i = 0; i < n; ++i){
            if (chk[i] == 0 && computers[start][i] == 1) {
                chk[i] = 1;
                dfs(i, n, computers);
            }
        }
    }
}
