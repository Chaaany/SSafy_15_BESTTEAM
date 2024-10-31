#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 23323 황소 다마고치
	// 그리디
	long long t, n, m;
	cin >> t;

	while (t--) {
		cin >> n >> m;
		int ans = 0;
		while (n) {
			n /= 2;
			++ans;
		}

		// 죽기 직전에만 먹이를 주는게 베스트
		cout << ans + m << '\n';
	}

	return 0;
}
