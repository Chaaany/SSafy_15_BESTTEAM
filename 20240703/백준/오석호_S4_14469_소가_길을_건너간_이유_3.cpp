#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 14469 소가 길을 건너간 이유 3
	// 그리디
	int n, a, b;
	vector<pair<int, int>> v;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> a >> b;
		v.push_back(make_pair(a, b));
	}

	// 정렬
	sort(v.begin(), v.end());

	int ans = v[0].first + v[0].second;

	for (int i = 1; i < n; ++i) {
		// 들어오자마자 처리되는 케이스
		if (ans <= v[i].first) ans = v[i].first + v[i].second;
		// 대기하다 처리되는 케이스
		else ans += v[i].second;
	}

	cout << ans;

	return 0;
}
