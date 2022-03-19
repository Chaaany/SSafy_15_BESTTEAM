package boj;

import java.util.*;

public class Boj_16928 {
	static int N, M, ladderAndSnake[];
	static int loc = 1;
	static boolean[] v = new boolean[101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ladderAndSnake = new int[107];

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			if (start < end) {
				ladderAndSnake[start] = end;
			} else {

				ladderAndSnake[end] = start;
			}
		}
		int idx1 = 0;
		int idx2 = 1;
		int[] cnt = new int[99999];
		while (true) {
			for (int dice = 6; dice > 0; dice--) {
				int moveTo = loc + dice;
				int temp = ladderAndSnake[moveTo];
				moveTo = temp != 0 ? temp : moveTo;

				if (moveTo <= 100) {
					if (v[moveTo] == false) {
						v[moveTo] = true;
						q.add(moveTo);
						cnt[idx2++] = cnt[idx1] + 1;
					}
				}
			}
			loc = q.poll();
			idx1++;
			if (loc == 100)
				break;
		}
		System.out.println(cnt[idx1]);
	}
}
