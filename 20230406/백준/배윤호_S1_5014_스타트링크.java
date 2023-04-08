import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int F, S, G, U, D;
	static int count = 0;
	static boolean check = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken()); // 총 건물 층 수
		S = Integer.parseInt(st.nextToken()); // 강호가 있는 층
		G = Integer.parseInt(st.nextToken()); // 스타트 링크 회사 위치
		U = Integer.parseInt(st.nextToken()); // U 버튼 누르면 올라가는 층 수
		D = Integer.parseInt(st.nextToken()); // D 버튼 누르면 내려가는 층 수
		bfs();
		if (check)
			System.out.println(count);
		else {
			System.out.println("use the stairs");
		}
	}

	private static void bfs() {
		boolean[] v = new boolean[F + 1];
		Queue<Integer> que = new LinkedList<>();
		v[S] = true;
		que.add(S);
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int cur = que.poll();
				if (cur == G) {
					check = true;
					return;
				}
				if (cur + U <= F && v[cur + U] == false) {
					que.add(cur + U);
					v[cur + U] = true;
				}
				if (cur - D >= 1 && v[cur - D] == false) {
					que.add(cur - D);
					v[cur - D] = true;
				}
			}
			count++;
		}

	}

}
