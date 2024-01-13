#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 29792 규칙적인 보스돌이
	// DP
	long long n, m, k, p, q;
	long long d[50] = { 0 }; // 데미지 배열
	long long arr[50] = { 0 }; // 하나의 캐릭터가 최대로 벌 수 있는 메소 배열
	long long dp[50][901] = { 0 };
	vector<pair<long long, long long>> v; // 보스벡터

	cin >> n >> m >> k;
	// 데미지 입력받기
	for (int i = 0; i < n; ++i) {
		cin >> d[i];
	}

	// v 채우기
	for (int i = 0; i < k; ++i) {
		cin >> p >> q;
		v.push_back(make_pair(p, q));
	}

	// 가장 효율적인 요소부터 브루트포스돌리기
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < k; ++j) {
			for (int a = 900; a >= 0; --a) {
				if (v[j].first % d[i] == 0) {
					if (a - (v[j].first / d[i]) >= 0) dp[i][a] = max(dp[i][a], dp[i][a - (v[j].first / d[i])] + v[j].second);
				}
				else {
					if (a - (v[j].first / d[i] + 1) >= 0) dp[i][a] = max(dp[i][a], dp[i][a - (v[j].first / d[i] + 1)] + v[j].second);
				}
			}
		}
		
		long long maxValue = *max_element(dp[i], dp[i] + 901);
		arr[i] = maxValue;
	}

	sort(arr, arr + 50, greater<>());

	long long ans = 0;
	for (int i = 0; i < m; ++i) ans += arr[i];
	cout << ans;

	return 0;
}
