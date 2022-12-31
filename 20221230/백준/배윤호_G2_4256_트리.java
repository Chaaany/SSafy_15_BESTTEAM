import java.io.*;
import java.util.*;

public class Main {
	static int[] pre, in;
	static StringBuilder sb = new StringBuilder(); // 후위순회를 저장할 스트링 빌더

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine()); // 테케
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine()); // 노드 수
			pre = new int[n + 1]; // 전위순회 트리 저장할 배열
			in = new int[n + 1]; // 중위순회 트리 저장할 배열
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				pre[i] = Integer.parseInt(st.nextToken()); // 전위 순회 저장
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				in[i] = Integer.parseInt(st.nextToken()); // 중위 순회 저장

			}

			find(0, 0, n); // 후위 순회 찾기 루트노드 시작점
			sb.append("\n"); // 테케마다 줄바꿈
		}

		System.out.println(sb.toString());

	}

	static void find(int root, int s, int e) {
		int rootIdx = pre[root]; // 전위 순회 루트노드
		for (int i = s; i < e; i++) {
			if (in[i] == rootIdx) { // 중위 순회에서 루트노드 위치 찾기
				find(root + 1, s, i); // 왼쪽트리의 루트노드 찾기
				find(root + i + 1 - s, i + 1, e); // 오른쪽 트리의 루트노드 찾기
				sb.append(rootIdx + " "); // 루트노드 추가 왼쪽 -> 오른쪽 -> 가운데 가 후위순회
			}
		}
	}
}
