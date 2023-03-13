import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17472_BridgeMaking2 {
	static int N, M;
	static int[][] map;
	static int index = 1;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] v;
	static ArrayList<Edge>[] graph;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		int cnt = 0;
		int ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 섬 분류하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && v[i][j] == false) {
					number(i, j);
				}
			}
		}

		graph = new ArrayList[index];
		for (int i = 1; i < index; i++) {
			graph[i] = new ArrayList<>();
		}

		// 섬마다 뻗어나가서 가능한 다리 최소값 구하기 큐에 다리 다 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					bridge(i, j);
				}
			}
		}

		// 이 다리들로 최소 신장 트리 구하기
		// 프림 알고리즘 준비
		boolean[] visit = new boolean[index];
		pq.add(new Edge(1, 0));

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (visit[edge.node]) {
				continue;
			}
			visit[edge.node] = true;
			ans += edge.distance;
			for (Edge next : graph[edge.node]) {
				if (!visit[next.node]) {
					pq.add(next);
				}
			}
			// 모든 정점을 다 방문했으면 탈출
			if (++cnt == index - 1)
				break;
		}
		// 만약 다리 다 연결 못했으면 -1
		if (cnt != index - 1) {
			System.out.println(-1);
		}
		// 다 연결했으면 최소값 출력
		else {
			System.out.println(ans);
		}
	}

	private static void bridge(int r, int c) {
		int start = map[r][c];
		for (int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			int distance = 0;
			int end = 0;
			while (true) {
				nr += dr[d];
				nc += dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (map[nr][nc] == 0) {
						distance++;
					} else if (map[nr][nc] == start) {
						distance = 0;
						break;
					} else {
						end = map[nr][nc];
						break;
					}
				} else {
					distance = 0;
					break;
				}

			}
			if (distance >= 2) {
				graph[start].add(new Edge(end, distance));
				graph[end].add(new Edge(start, distance));
			}
		}

	}

	private static void number(int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { r, c });
		map[r][c] = index;
		v[r][c] = true;
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && !v[nr][nc]) {
					map[nr][nc] = index;
					v[nr][nc] = true;
					que.add(new int[] { nr, nc });
				}
			}
		}
		index++;
	}

	public static class Edge implements Comparable<Edge> {
		int node;
		int distance;

		Edge(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.distance, e.distance);
		}

	}

}
