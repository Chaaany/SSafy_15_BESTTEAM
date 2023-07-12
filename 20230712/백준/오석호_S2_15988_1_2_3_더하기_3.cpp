#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 15988 1, 2, 3 더하기 3
	// DP
	int t, n;
	long long dp[1000001] = { 0 };
	dp[1] = 1; // 1은 1 1가지
	dp[2] = 2; // 2는 1+1, 2 2가지
	dp[3] = 4; // 3은 1+1+1, 2+1, 1+2, 3 4가지
	cin >> t;
	for (int i = 0; i < t; ++i) {
		cin >> n;
		for (int j = 4; j <= n; ++j) {
			if (dp[j]) continue;
			dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1000000009;
		}
		cout << dp[n] << '\n';
	}

	return 0;
}
