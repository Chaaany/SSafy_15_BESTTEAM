#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 17103 골드바흐 파티션
	// 수학
	int t, n;
	bool isNotPrime[1000001] = { 0 };
	cin >> t;

	// 소수 구하기
	for (int i = 2; i <= 1000000; ++i) {
		if (!isNotPrime[i]) {
			for (int j = i * 2; j <= 1000000; j += i) isNotPrime[j] = true;
		}
	}

	while (t--) {
		cin >> n;
		int ans = 0;
		for (int i = 2; i <= n / 2; ++i) {
			if (!isNotPrime[i] && !isNotPrime[n - i]) ++ans;
		}
		cout << ans << '\n';
	}

	return 0;
}
