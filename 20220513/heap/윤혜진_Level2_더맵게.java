import java.util.*;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}

		boolean isP = false;
		while (pq.size() >= 2) {
			int a = pq.poll();
			int b = pq.poll();
			pq.add(a + (b * 2));
			answer++;

			if (pq.peek() >= K) {
				isP = true;
				break;
			}
		}

		if (isP)
			return answer;
		else
			return -1;
	}
}
