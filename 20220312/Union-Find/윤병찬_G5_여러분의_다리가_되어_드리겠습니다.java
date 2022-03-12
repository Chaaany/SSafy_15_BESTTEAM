import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17352 {
	static int parent[], a, b;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;

		int N = Integer.parseInt(br.readLine());
		int temp = 0;
		int cnt = 0;
		parent = new int[N + 1]; // 0번째 노드는 사용 안함
		makeSet();
		for (int i = 0; i < N - 2; i++) {
			stz = new StringTokenizer(br.readLine());
			a = Integer.parseInt(stz.nextToken());
			b = Integer.parseInt(stz.nextToken());
			union(a, b);
		}

		for (int i = 1; i < N + 1; i++) {

			if (find(i) == i && cnt == 1) { // 뿌리가 자기 자신인 두 번째 친구 발견
				if (N == 2) { // 친구 2명?
					System.out.println(1 + " " + 2);
				} else {
					System.out.println(i + " " + temp);
				}
			} else if (find(i) == i && cnt == 0) {
				temp = i;
				cnt++;
			}
		}

	}

	private static void makeSet() {
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	private static int find(int x) {
		if(x == parent[x]) return parent[x];
		
		return parent[x] = find(parent[x]);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;

		parent[y] = x;
	}

}
