import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, score;
	static int[][] classroom, friends;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		classroom = new int[N+1][N+1];
		friends = new int[N*N+1][4];
		
		for (int i = 0; i < N*N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			friends[num][0] = Integer.parseInt(st.nextToken());
			friends[num][1] = Integer.parseInt(st.nextToken());
			friends[num][2] = Integer.parseInt(st.nextToken());
			friends[num][3] = Integer.parseInt(st.nextToken());
		
			position(num);
		}
		
		// 만족도 조사
		for (int r = 1; r < N+1; r++) {
			for (int c = 1; c < N+1; c++) {
				int num = classroom[r][c];
				int friendCnt = 0;
				
				// 친구 수 count
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(!(nr>=1 && nr<N+1 && nc>=1 && nc<N+1)) continue;
					
					for (int i = 0; i < 4; i++) {
						if(classroom[nr][nc]==friends[num][i])
							friendCnt++;
					}
				}
				
				switch(friendCnt) {
				case 1:
					score += 1;
					break;
				case 2:
					score += 10;
					break;
				case 3:
					score += 100;
					break;
				case 4:
					score += 1000;
					break;
				}
				
			}
		}
		
		System.out.println(score);

	}

	
	private static void position(int num) {
		int maxFriend = 0;
		int maxBlank = 0;
		
		int fr = 0;
		int fc = 0;
		
		for (int r = 1; r < N+1; r++) {
			for (int c = 1; c < N+1; c++) {
				if(classroom[r][c] != 0) continue;
				
				int friendCnt = 0;
				int blankCnt = 0;
				
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(!(nr>=1 && nr<N+1 && nc>=1 && nc<N+1)) continue;
					
					int value = classroom[nr][nc];
					if(value == 0) blankCnt++;
					else {
						for (int i = 0; i < 4; i++) {
							if(value==friends[num][i])
								friendCnt++;
						}
					}
					
				}
				
				// 친구가 주위에 가장 많은 칸으로
				if(friendCnt > maxFriend) {
					maxFriend = friendCnt;
					maxBlank = blankCnt;
					fr = r;
					fc = c;
				}
				// 친구 수가 같으면
				else if(friendCnt == maxFriend) {
					// 비어있는 칸이 많은 칸으로
					if(blankCnt > maxBlank) {
						maxBlank = blankCnt;
						fr = r;
						fc = c;
					}
					// 비어있는 칸 개수가 같으면
					else if(blankCnt == maxBlank) {
						// 행 번호가 작은 칸으로
						if(r < fr) {
							fr = r;
							fc = c;
						}
						// 행 번호 같은 칸이 여러개면
						else if(r == fr) {
							// 열 번호가 작은 칸으로
							if(c < fc) {
								fr = r;
								fc = c;
							}
						}
            // 남은 칸의 경우 (주변에 친구,빈칸 없음)
						else if(fr==0 && fc==0) {
							fr = r;
							fc = c;
						}
					}
				}
			}
		}

		classroom[fr][fc] = num;
		
	}

}
