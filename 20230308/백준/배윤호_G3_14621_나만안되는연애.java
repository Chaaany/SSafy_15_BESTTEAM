import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_14621_LoveWithoutMe {
//프림 알고리즘
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] gender = new int[N + 1];
		st = new StringTokenizer(br.readLine());
    //성별 입력받고 저장해두기
		for (int i = 1; i < N + 1; i++) {
			if (st.nextToken().charAt(0) == 'M') {
				gender[i] = 0;
			} else {
				gender[i] = 1;
			}
		}
		ArrayList<Load>[] graph = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
    //만약 성별이 같으면 그래프에 안 넣을거 어차피 사용 안할거니까
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (gender[a] == gender[b]) {
				continue;
			}
			graph[a].add(new Load(b, c));
			graph[b].add(new Load(a, c));
		}
		int ans = 0;
		int cnt = 0;
		PriorityQueue<Load> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.value, p2.value));
		boolean[] v = new boolean[N + 1];
		pq.add(new Load(1, 0));
		while (!pq.isEmpty()) {
			Load load = pq.poll();

			if (v[load.node]) {
				continue;
			}
			v[load.node] = true;
			ans += load.value;
			for (Load next : graph[load.node]) {
				if (!v[next.node]) {
					pq.add(next);
				}
			}
			if (++cnt == N) {
				break;
			}
		}
    //만약 cnt가 N이 안되는데 while문 탈출한거면 다 연결 못한거니까 -1
		if (cnt != N) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}

	public static class Load {
		int node;
		int value;

		Load(int node, int value) {
			this.node = node;
			this.value = value;
		}
	}

}
