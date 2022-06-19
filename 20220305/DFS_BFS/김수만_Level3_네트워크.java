class Solution {
    
    int N;
    int [][] com;
    boolean[] v;
    
    public int solution(int n, int[][] computers) {
        N = n;
        com = computers;
        v = new boolean[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            if(v[i]) continue;
            v[i] = true;
            dfs(i);
            ans++;
        }
        return ans;
    }
    
    private void dfs(int num){
        
        for(int i=0; i<N; i++){
            if(v[i] || com[num][i] == 0) continue;
            v[i] = true;
            dfs(i);
        }
    }
}