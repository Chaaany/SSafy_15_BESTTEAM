#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 14495 피보나치 비스무리한 수열
	// DP
	int n;
	long long dp[117] = { 0 };
	cin >> n;
	dp[1] = 1;
	dp[2] = 1;
	dp[3] = 1;
	for (int i = 4; i <= n; ++i) dp[i] = dp[i - 1] + dp[i - 3];
	cout << dp[n];

	return 0;
}
