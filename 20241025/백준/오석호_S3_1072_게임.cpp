#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1072 게임
	// 이분탐색
	long long x, y;
	cin >> x >> y;
	long long p = (y * 100 / x);

	if (p >= 99) cout << -1;
	else {
		int l = 0;
		int r = 1000000001;

		while (l <= r) {
			int m = (l + r) / 2;
			int tmp = (y + m) * 100 / (x + m);
			if (p < tmp) r = m - 1;
			else l = m + 1;
		}
		cout << l;
	}

	return 0;
}
