#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1024 수열의 합
	// 수학
	int n, l;
	cin >> n >> l;

	for (int i = l; i <= 100; ++i) {
		int tmp = n - (i - 1) * i / 2;
		if (tmp >= 0 && !(tmp % i)) {
			int elem = tmp / i;
			while (i--) cout << elem++ << " ";
			return 0;
		}
	}

	cout << -1;

	return 0;
}
