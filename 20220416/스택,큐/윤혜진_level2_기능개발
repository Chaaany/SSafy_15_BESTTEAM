import java.io.*;
import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int day = 1;

		int[] complete = new int[100];
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < progresses.length; i++) {
			while (progresses[i] + speeds[i] < 100) {
				day++;
				progresses[i] += speeds[i];
			}
			q.add(day);
			day = 1;
		}

		int prev = -1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (prev == -1) {
				complete[cur]++;
				prev = cur;
			} else if (prev >= cur) {
				complete[prev]++;
			} else if (prev < cur) {
				complete[cur]++;
				prev = cur;
			}
		}

		int cnt = 0;
		for (int i = 0; i < complete.length; i++) {
			if (complete[i] != 0)
				cnt++;
		}

		int[] answer = new int[cnt];
		int index = 0;

		for (int i = 0; i < complete.length; i++) {
			if (complete[i] != 0) {
				answer[index] = (complete[i]);
				index++;
			}
		}

		return answer;
	}
}
