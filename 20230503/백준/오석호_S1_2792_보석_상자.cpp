#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2792 보석 상자
	// 이분탐색
	int n, m, tmp;
	int ans = 0;
	vector<int> v;
	cin >> n >> m;
	for (int i = 0; i < m; ++i) {
		cin >> tmp;
		v.push_back(tmp);
	}
	sort(v.begin(), v.end());
	int l = 1;
	int r = v[m - 1];
	while (l <= r) {
		int mid = (l + r) / 2;
		int cnt = 0;
		for (int i = 0; i < m; ++i) {
			cnt += v[i] / mid;
			if (v[i] % mid != 0) ++cnt;
		}

		if (cnt <= n) {
			r = mid - 1;
			ans = mid;
		}
		else l = mid + 1;
	}
	cout << ans;

	return 0;
}
