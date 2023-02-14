import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1486_ClimbingMountain {
	static int N, M, T, D;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dn = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
    //맵의 i,j 요소를 일자로 좍 펴서 인덱스를 만들 때 사용
		dn[0] = -M; // 0번째 위치는 현재 위치 -M번째 인덱스
		dn[1] = 1; // 1번째 위치는 인덱스 +1
		dn[2] = M; // 2번째 위치는 현재 위치 +M번째 인덱스
		dn[3] = -1; //3번째 위치는 인덱스 -1
    
    //입력 받아서 정수 높이로 변환해서 넣기
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) <= 90) {
					map[i][j] = s.charAt(j) - 65;
				} else {
					map[i][j] = s.charAt(j) - 71;
				}
			}
		}
    
		int max = map[0][0]; //도달할 수 있는 최대 높이를 시작점으로 초기화
		int[][] map2 = new int[N * M][N * M]; // 0,0부터 N-1,M-1 지점까지 최단 거리를 구하기 위한 배열 생성
    //배열 큰 값으로 초기화
		for (int i = 0; i < map2.length; i++) {
			Arrays.fill(map2[i], Integer.MAX_VALUE / 10);
		}
    // map[i][j]의 인접한 구역들에 갈 수 있는지, 갈 수 있으면 소모되는 에너지 값 저장
    // i,j를 i*M+j로 인덱스를 주고 map2 배열에 아까 만들어둔 dn배열을 이용해서 주변 인덱스까지의 소모값 계산 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int d = 0; d < 4; d++) {
					if (i + dr[d] >= 0 && i + dr[d] < N && j + dc[d] >= 0 && j + dc[d] < M) {
						if (Math.abs(map[i][j] - map[i + dr[d]][j + dc[d]]) <= T) {
							int index = i * M + j;
							map2[index][index + dn[d]] = cal(map[i][j], map[i + dr[d]][j + dc[d]]);
						}
					}
				}
			}
		}
    //갈 수 있는 인덱스끼리 값을 저장했으므로 플로이드 와샬 돌려 경출도
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2.length; j++) {
				for (int k = 0; k < map2.length; k++) {
					if (map2[j][k] > map2[j][i] + map2[i][k]) {
						map2[j][k] = map2[j][i] + map2[i][k];
					}
				}
			}
		}
    // 그리고 0,0부터 해당인덱스 까지 가는 값 + 해당 인덱스부터 0,0 오는 값 을 더해서 D를 안넘는다면 max값을 더 큰 값으로 갱신
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int index = i * M + j;
				if (map2[0][index] + map2[index][0] <= D) {
					max = Math.max(max, map[i][j]);
				}
			}
		}
		System.out.println(max);
	}
  // i -> j 이동시 소모되는 에너지 값 계산하는 함수
	private static int cal(int i, int j) {
		if (i >= j) {
			return 1;
		} else {
			int temp = 0;
			temp = (j - i) * (j - i);
			return temp;
		}
	}

}
