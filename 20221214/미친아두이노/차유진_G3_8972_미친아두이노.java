import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_G3_8972_미친아두이노 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int[][] map = new int[R][C];
		int[] myloc = new int[2]; // 내 위치
		Queue<int[]> oploc = new LinkedList<>(); // 상대의 위치 리스트
		
		for (int i = 0; i < R; i++) {
			String line = sc.next();
			for (int j = 0; j < C; j++) {
				/* 0: 공터, -1: 나, 1: 상대 */
				if(line.charAt(j) == '.') {
					map[i][j] = 0;
				} else if(line.charAt(j) == 'I') {
					myloc[0] = i;
					myloc[1] = j;
					map[i][j] = -1;
				} else {
					oploc.offer(new int[] {i,j});
					map[i][j] = 1;
				}
			}
		}
		
		String cmd = sc.next();
		int[] dr = {1, 1, 1, 0, 0, 0,-1,-1,-1};
		int[] dc = {-1,0, 1,-1, 0, 1,-1, 0, 1};
		
		for(int i = 1; i <= cmd.length(); i++) {
			/* 내 위치 이동 */
			int d = Integer.parseInt(Character.toString(cmd.charAt(i-1))) -1;
			map[myloc[0]][myloc[1]] = 0;
			myloc[0] += dr[d];
			myloc[1] += dc[d];
			if(map[myloc[0]][myloc[1]] == 1) { // 겹치면 종료
				System.out.println("kraj "+i);
				return;
			} else {
				map[myloc[0]][myloc[1]] = -1;
			}
			
			/* 상대 위치 하나씩 이동 */
			while(!oploc.isEmpty()) {
				int[] rc = oploc.poll();
				int r = rc[0];
				int c = rc[1];
				int dist = Math.abs(myloc[0]-r) + Math.abs(myloc[1]-c);
				int nr = 0;
				int nc = 0;
				for(int k = 0; k < 9; k++) { // 최소거리가 되는 방향 찾기
					if(k == 4) continue;
					nr = rc[0] + dr[k];
					nc = rc[1] + dc[k];
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
					if(Math.abs(myloc[0]-nr) + Math.abs(myloc[1]-nc) < dist) {
						dist = Math.abs(myloc[0]-nr) + Math.abs(myloc[1]-nc);
						r = nr;
						c = nc;
					}
				}

				map[rc[0]][rc[1]]--; // 원래 위치에 있던 개수 카운트 다운
				if(map[r][c] < 0) { // 내 위치와 만나면 종료
					System.out.println("kraj "+i);
					return;
				} else { // 상대 아두이노끼리 겹치면 일단 해당 위치에 있는 개수 카운트 업
					map[r][c]++;
				}
			}
			
			for(int j = 0; j < R; j++) {
				for(int k = 0; k < C; k++) {
					if(map[j][k] > 1) { // 한 위치에 아두이노가 1개보다 많으면 다 사망
						map[j][k] = 0;
					} else if(map[j][k] == 1) { // 상대 위치 리스트에 추가
						oploc.offer(new int[] {j,k});
					}
				}
			}
		}
		printMap(map,R,C);
		
	}

	private static void printMap(int[][] map, int r, int c) {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] == 0) {
					System.out.print(".");
				}else if(map[i][j] == -1) {
					System.out.print("I");
				}else {
					System.out.print("R");
				}
			}
			System.out.println();
		}
		
	}

}
