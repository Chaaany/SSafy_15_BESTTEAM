import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1486_ClimbingMountain2 {
	static int N, M, T, D;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		// 입력 받은 배열을 정수값으로 변환해서 저장
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
		// 다익스트라로 0,0 에서 가는거랑 0,0까지 오는 배열을 구함
		int[][] go = find(false);
		int[][] back = find(true);
		// 최대값을 시작점으로 초기화
		int max = map[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (go[i][j] + back[i][j] <= D) { // 만약 가는 값 + 오는 값이 D보다 작거나 같으면
					max = Math.max(max, map[i][j]); // map[i][j]랑 max중에 최대값으로 갱신
				}
			}
		}
		System.out.println(max);
	}

	// 다익스트라
	private static int[][] find(boolean reverse) { // reverse가 false면 0,0에서 가는 값, true면 0,0까지 오는 값
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.d, n2.d));
		int[][] dist = new int[N][M];
		boolean[][] v = new boolean[N][M];
		for (int i = 0; i < v.length; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE / 10);
		}
		// 시작점 0,0 가중치 0
		pq.add(new Node(0, 0, 0));
		dist[0][0] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int cr = cur.r;
			int cc = cur.c;
			int cd = cur.d;

			if (v[cr][cc])
				continue;
			v[cr][cc] = true;
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					int gap = 0;
					if (reverse) { // 만약 reverse 가 true면
						gap = cal(map[nr][nc], map[cr][cc]); // 다음 점->현재 점의 가중치를 더함
					} else { // false면
						gap = cal(map[cr][cc], map[nr][nc]); // 원래 다익스트라처럼 현재 점 -> 다음 점의 가중치를 더함
					}
					if (gap == -1 || dist[nr][nc] < cd + gap)
						continue;
					dist[nr][nc] = cd + gap;
					pq.add(new Node(nr, nc, dist[nr][nc]));
				}
			}
		}
		return dist;
	}

	private static int cal(int i, int j) {
		// i-j가 T보다 크면 못 감
		if (Math.abs(i - j) > T)
			return -1;
		// i가 j보다 작거나 같으면 1만에 감
		if (i >= j) {
			return 1;
		}
		// j가 i보다 크면 j-i의 제곱만큼 써야 감
		else {
			int temp = 0;
			temp = (j - i) * (j - i);
			return temp;
		}
	}

	// 다익스트라 pq에 쓸 노드
	public static class Node {
		int r, c, d;

		// r,c는 행 렬 d는 가중치 r,c까지 소모되는 값
		public Node(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

}
