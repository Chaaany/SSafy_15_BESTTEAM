import java.util.*;
class Solution {
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] dis = new int[n+1][n+1];
		for(int i=0; i<=n; i++)
			Arrays.fill(dis[i], Integer.MAX_VALUE/2);
		for(int i=0; i<results.length; i++) 
			dis[results[i][0]][results[i][1]] = 1;
		
		//floyd-warshall
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				if(k == i) continue;
				for(int j=1; j<=n; j++) {
					if(i == j || k == j) continue;
					dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
				}
			}
		}
		
		//i->j로 가는 방법, j->i로 가는 방법이 없는 경우에는 자신의 순위를 알 수 없다.
		for(int i=1; i<=n; i++) {
			boolean flag = true;
			for(int j=1; j<=n; j++) {
				if(i == j) continue;
				if(dis[i][j] == Integer.MAX_VALUE/2 && dis[j][i] == Integer.MAX_VALUE/2) {
					flag = false;
					break;
				}
			}
			if(flag) answer++;
		}
        return answer;
    }
}
