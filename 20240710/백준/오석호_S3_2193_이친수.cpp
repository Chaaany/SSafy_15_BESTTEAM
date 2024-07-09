#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2193 이친수
	// DP
	int n;
	long long dp[91] = { 0 };
	cin >> n;

	dp[1] = 1;
	dp[2] = 1;

	// 무조건 10으로 시작
	for (int i = 3; i <= n; i++) dp[i] = dp[i - 2] + dp[i - 1];

	cout << dp[n];

	return 0;
}
