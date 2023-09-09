#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 11060 점프점프
	// dp
	int dp[1101] = { 0 };
	int arr[1001] = { 0 };
	int n;
	cin >> n;

	// 초기화
	for (int i = 1; i <= 1100; ++i) dp[i] = 99999999;
	for (int i = 1; i <= n; ++i) cin >> arr[i];
	dp[1] = 0;
	for (int i = 1; i < n; ++i) {
		for (int j = 1; j <= arr[i]; ++j) {
			if (i + j <= n) dp[i + j] = min(dp[i + j], dp[i] + 1);
		}
	}
	if (dp[n] == 99999999) cout << -1;
	else cout << dp[n];

	return 0;
}
