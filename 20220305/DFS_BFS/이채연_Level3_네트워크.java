class Solution {
    static int[][] c;
    static int N;
    static boolean[]  visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        c=computers;
        N=n;
        visited=new boolean[n];
        for (int i=0; i<n; i++){
            if (!visited[i]){       //미방문한 노드에 대해 DFS 탐색
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int idx){
        visited[idx]=true;
        for (int i=0; i<N; i++){    //모든 인접한 미방문한 컴퓨터에 대해 방문
            if (c[idx][i]==1 && !visited[i]){
                dfs(i);
            }
        }
    }
    
    
}
