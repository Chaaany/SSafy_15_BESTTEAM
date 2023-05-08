#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 11501 주식
	// 그리디
	int t, n, c;
	cin >> t;
	while (t--) {
		cin >> n;
		vector<int> v(n);
		for (int i = 0; i < n; ++i) cin >> v[i];
		long long ans = 0; // 1000000 * 10000은 100억 -> long long 범위
		// 가장 비싼 때가 언제인지 뒤에서부터 확인하기
		int maxIdx = n - 1;
		for (int i = n - 2; i >= 0; --i) {
			if (v[maxIdx] > v[i]) ans += v[maxIdx] - v[i]; // 차익
			else maxIdx = i;
		}
		cout << ans << '\n';
	}

	return 0;
}
