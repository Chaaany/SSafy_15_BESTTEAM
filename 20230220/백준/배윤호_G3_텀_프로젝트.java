import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9466_TermProject {
	static boolean[] v, check;
	static int[] like;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			count = 0;
			v = new boolean[n + 1];
			check = new boolean[n + 1];
			like = new int[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i < n + 1; i++) {
				like[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i < n + 1; i++) {
				if (check[i]) // 이미 사이클이 된 친구는 find 함수 안 돌린다.
					continue;
				find(i);
			}
			sb.append(n - count).append("\n");
		}
		System.out.println(sb);

	}

	private static void find(int n) {
		// 이미 방문한 곳에 다시 왔으면 (사이클 완성)
		if (v[n]) {
			check[n] = true; // 이 친구는 탐색 끝
			count++; // 팀 편성 완료 인원 증가
		}
		// 아직 방문 안했으면 방문처리
		else {
			v[n] = true;
		}

		// 다음 학생이 아직 사이클 완성되지 않았으면(팀 결성 못했으면)
		if (!check[like[n]]) {
			find(like[n]); // 팀 찾으러 가보자
		}

		check[n] = true; // 그리고 이 친구는 사이클이 형성 되든 안되든 재귀를 통해 결과가 나올것이므로 다시 볼 필요 없으니 탐색 끝

	}

}
