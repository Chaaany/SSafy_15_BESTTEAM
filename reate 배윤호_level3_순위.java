class Solution {
    public int solution(int n, int[][] results) {
        		int[][] map =new int[n+1][n+1];
        int answer = 0;
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if(i==j) continue;
				map[i][j] = Integer.MAX_VALUE/100;
			}
		}
		for (int i = 0; i < results.length; i++) {
			map[results[i][0]][results[i][1]]=1;
		}
		
		for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		
		for (int i = 1; i < n + 1; i++) {
			int count = 0;
			for (int j = 1; j < n + 1; j++) {
				if (map[i][j] != Integer.MAX_VALUE/100)
					count++;
			}
			for (int j = 1; j < n + 1; j++) {
				if (map[j][i] != Integer.MAX_VALUE/100)
					count++;
			}
			count = count - 2;
			if (count == n - 1) {
				answer++;
			}
		}
		System.out.println(answer);

        return answer;
    }
}
