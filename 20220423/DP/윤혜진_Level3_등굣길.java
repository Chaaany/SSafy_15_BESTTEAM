import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n+1][m+1];

		// 웅덩이 표시
		for (int[] p : puddles) {
			map[p[1]][p[0]] = -1;
		}

		map[1][1] = 1;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (i == 1 && j == 1) continue;
				else if (map[i][j] == -1) // 웅덩이 있는 곳
					map[i][j] = 0;
				else {
					int x = 0;
					int y = 0;
					if (map[i - 1][j] > 0) x = map[i - 1][j];
					if (map[i][j - 1] > 0) y = map[i][j - 1];
					map[i][j] = x + y;
				}
                map[i][j] %= 1000000007;
			}
		}

		answer = map[n][m];
		return answer;
	}

}
