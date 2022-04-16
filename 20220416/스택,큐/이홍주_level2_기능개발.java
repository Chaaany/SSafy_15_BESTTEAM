import java.util.*;

class 이홍주_level2_기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {

		Queue<Integer> qu = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			int tmp = progresses[i];
			int tmp2 = speeds[i];
			int time = 0;
			while (true) {
				if (tmp >= 100)
					break;
				tmp += tmp2;
				time++;
			}
			qu.add(time);
		}

		int index = 0;
		int[] arr = new int[progresses.length];
		while (!qu.isEmpty()) {
			int tmp = qu.poll();
			int sum = 1;
			if (!qu.isEmpty()) {
				while (qu.peek() <= tmp) {
					qu.poll();
					sum++;
					if (qu.isEmpty())
						break;
				}
			}
			arr[index++] = sum;
		}
		int[] answer = new int[index];
		for (int i = 0; i < index; i++) {
			answer[i] = arr[i];
		}
		return answer;
	}
}
