#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1535 안녕
	// DP
	int n;
	int dp[101] = { 0 };
	int cost[21] = { 0 };
	int happy[21] = { 0 };
	cin >> n;
	for (int i = 0; i < n; ++i) cin >> cost[i];
	for (int i = 0; i < n; ++i) cin >> happy[i];

	// DP 돌리기
	for (int i = 0; i < n; ++i) {
		for (int j = 99; j >= cost[i]; --j) {
			dp[j] = max(dp[j], dp[j - cost[i]] + happy[i]);
		}
	}

	// 체력 99를 썼을 때의 최댓값
	cout << dp[99];

	return 0;
}
