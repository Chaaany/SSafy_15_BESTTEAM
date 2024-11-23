#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1059 좋은 구간
	// 정렬
	int l, input, n;
	cin >> l;

	vector<int> v;
	for (int i = 0; i < l; ++i) {
		cin >> input;
		v.push_back(input);
	}

	sort(v.begin(), v.end());

	cin >> n;

	// n보다 큰 수 중 가장 가까운 수 찾기
	int s = 0;
	int e = 0;
	for (int i = 0; i < l; ++i) {
		if (n < v[i]) {
			if (i > 0) s = v[i - 1];
			e = v[i];
			break;
		}
	}

	// s가 n과 같지 않으면 범위가 존재 (같으면 0)
	int ans = 0;
	if (s != n) {
		for (int i = min(s + 1, n); i <= n; ++i) {
			for (int j = max(i + 1, n); j < e; ++j) ++ans;
		}
	}

	cout << ans;

	return 0;
}
