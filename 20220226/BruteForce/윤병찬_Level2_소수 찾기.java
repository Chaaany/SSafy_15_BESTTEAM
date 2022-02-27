import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
	static char[] nums;
	static List<Integer> answerList;

	public int solution(String numbers) {
		int answer = 0;
		answerList = new ArrayList<>();
		for (int i = 1; i <= numbers.length(); i++) {
			nums = new char[i];
			perm(0, i, numbers, new boolean[numbers.length()]);
		}
		answer = answerList.size();
		return answer;
	}

	private void perm(int cnt, int N, String numbers, boolean[] visited) {
		if (cnt == N) {
			int temp = Integer.parseInt(String.copyValueOf(nums));
			if (!answerList.contains(temp) && isPrime(temp)) {
				answerList.add(temp);
			}
			return;
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			nums[cnt] = numbers.charAt(i);
			perm(cnt + 1, N, numbers, visited);
			visited[i] = false;
		}
	}

	private boolean isPrime(int temp) {
		if (temp == 1 || temp == 0)
			return false;
		for (int i = 2; i < temp; i++) {
			if (i * i > temp)
				return true;

			if (temp % i == 0)
				return false;
		}

		return true;
	}
}
