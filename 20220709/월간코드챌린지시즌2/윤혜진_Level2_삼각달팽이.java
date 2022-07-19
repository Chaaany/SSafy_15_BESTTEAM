class Solution {
    public int[] solution(int n) {
        int[][] snail = new int[n][n];
        
        int r = -1;
		int c = 0;
		int num = 0;

		boolean down = true;
		boolean right = false;
		boolean up = false;

		int prevR = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if(prevR != i) {
					if(down) {
						right = true;
						down = false;
					}
					else if(right) {
						up = true;
						right = false;
					}
					else if(up) {
						down = true;
						up = false;
					}
					prevR = i;
				}

				if (down)
					r++;
				else if (right)
					c++;
				else if (up) {
					r--;
					c--;
				}
				
				snail[r][c] = ++num;
			}
		}
        
        
        int[] answer = new int[num];
        int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(snail[i][j]!=0) {
					answer[idx] = snail[i][j];
					idx++;
				}
			}
		}
        return answer;
    }
}
