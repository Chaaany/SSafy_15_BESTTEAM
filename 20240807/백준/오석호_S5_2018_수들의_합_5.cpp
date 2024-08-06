#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2018 수들의 합 5
	// 투포인터
	int n;
	int s = 1;
	int e = 1;
	int sum = 0;
	int ans = 0;
	cin >> n;
	while (s <= e && e <= n) {
		// sum이 n보다 작으면 e를 한 칸 전진
		if (sum < n) sum += e++;
		else {
			// 정답인 케이스
			if (sum == n) ++ans;
			// 정답 or sum이 n보다 크면 s를 한 칸 전진
			sum -= s++;
		}
	}
	// 자기 자신도 더해주기 위해 +1
	cout << ans + 1;

	return 0;
}
