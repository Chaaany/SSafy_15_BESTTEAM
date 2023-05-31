#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1446 지름길
	// DP
	int n, d, start, end, shortcut;
	vector<pair<int, int>> v[10001];
	int dp[10001] = { 0 };
	cin >> n >> d;
	for (int i = 0; i < n; ++i) {
		cin >> start >> end >> shortcut;
		if (end > d || end - start < shortcut) continue;
		v[end].push_back(make_pair(start, shortcut));
	}
	// 고속도로를 하나씩 이어나가면서 dp값 계산
	for (int i = 1; i <= d; ++i) {
		dp[i] = dp[i - 1] + 1;
		// 해당 경로로 가는 모든 지름길을 확인
		for (int j = 0; j < v[i].size(); ++j) {
			dp[i] = min(dp[i], dp[v[i][j].first] + v[i][j].second);
		}
	}

	cout << dp[d];

	return 0;
}
