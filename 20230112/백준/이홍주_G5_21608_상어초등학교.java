import java.io.*;
import java.util.*;

public class BJ_21608_상어초등학교 {

	static int N, max_count;
	static int[][] map, line;
	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,-1,1,0};
	static ArrayList<int[]> likeList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		line = new int[N*N][5];
		
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		// 학생 번호 입력 받기
		for (int i = 0; i < N*N; i++) {
			st = new StringTokenizer(br.readLine());
			
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
			line[i][2] = Integer.parseInt(st.nextToken());
			line[i][3] = Integer.parseInt(st.nextToken());
			line[i][4] = Integer.parseInt(st.nextToken());
			hashMap.put(line[i][0],i);
		}
		
		// 학생 앉히기 시작
		for (int i = 0; i < N*N; i++) {
			// 비어있는 칸 중에서 좋아하는 번호 인접 많은 칸 (1)
			if(!checkLikeNum(i)) {
				// 여러개면 인접칸 중에서 비어있는 칸이 가장 많은 곳 (2)
				// 여러개면 행이 가장 작은 칸 -> 열이 작은 칸 (3)
				PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						if(o1[0]==o2[0]) return o1[1]-o2[1];
						else return  o1[0]-o2[0];
					}
				});
				checkEmptyKan(line[i][0], pq);
			}
		}
		
		int answer = 0;
		// 만족도 조사
		for (int i = 0; i < N; i++) {
			for (int j = 0;  j < N; j++) {
				int count=0;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];				
					if(cango(nr,nc) && checkLike(map[nr][nc], hashMap.get(map[i][j]))) count++;
				}
				if(count==1) answer+=1;
				else if(count==2) answer+= 10;
				else if(count==3) answer+= 100;
				else if(count==4) answer+= 1000;
			}
		}
		
		System.out.println(answer);
	}
	
	private static void checkEmptyKan(int x, PriorityQueue<int[]> pq) {
		for (int i = 0; i < likeList.size(); i++) {
			if(max_count == likeList.get(i)[2]) pq.add(new int[] {likeList.get(i)[0],likeList.get(i)[1]});			
		}
		
		map[pq.peek()[0]][pq.peek()[1]] = x;
		pq.clear();	
	}
	
	private static boolean checkLikeNum(int r) {
		int[][] checkMap = new int[N][N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(checkLike(map[i][j],r)) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						// 비어있는 칸 중
						if(cango(nr,nc) && map[nr][nc] == 0) {
							// 좋아하는 번호 카운트
							max = Math.max(max, ++checkMap[nr][nc]);
						}
					}
				}
			}
		}
		
		likeList = new ArrayList<>();		
		// 2번에 쓸 최대 비어있는 칸
		max_count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 놓을 공간이 빈공간인지 체크
				if(checkMap[i][j] == max && map[i][j] == 0) {		
					// 2번 조건을 위한 주변 빈공간 개수 체크
					int count=0;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(cango(nr,nc) && map[nr][nc] == 0) count++;
					}
					max_count = Math.max(max_count, count);
					likeList.add(new int[] {i,j,count});
				}				
			}
		}

		// 1번 조건 여러개
		if(likeList.size() != 1) return false;
		else {
			map[likeList.get(0)[0]][likeList.get(0)[1]] = line[r][0];
			likeList.clear();
			return true;
		}
	}
	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
	private static boolean checkLike(int mapNum, int r) {
		return mapNum == line[r][1] ||mapNum == line[r][2] || mapNum == line[r][3] || mapNum == line[r][4];
	}
}
