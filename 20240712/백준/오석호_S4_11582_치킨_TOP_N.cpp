#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 11582 치킨 TOP N
	// 수학
	int n, tmp, k;
	cin >> n;
	vector<int> v;
	for (int i = 0; i < n; ++i) {
		cin >> tmp;
		v.push_back(tmp);
	}
	cin >> k;

	// 머지소트
	int chk = n / 2;
	while (chk) {
		int range = n / chk;
		for (int i = 0; i < n - 1; i += range) sort(v.begin() + i, v.begin() + i + range);

		if (chk == k) {
			for (int i = 0; i < n; ++i) cout << v[i] << " ";
			cout << '\n';
			break;
		}

		chk /= 2;
	}

	return 0;
}
