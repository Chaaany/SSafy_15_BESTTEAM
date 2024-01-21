class Solution {
	static int ans = 0;

	public int solution(int[] numbers, int target) {
		perm(0, numbers, numbers.length, target, 0);
		
		return ans;
	}

	public static void perm(int cnt, int[] numbers, int length, int target, int total) {

		if (cnt == length) {
			if (total == target)
				ans++;
			return;
		}
		perm(cnt + 1, numbers, length, target, total - numbers[cnt]);
		perm(cnt + 1, numbers, length, target, total + numbers[cnt]);

	}
}
