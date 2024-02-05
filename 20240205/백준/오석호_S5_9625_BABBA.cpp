#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 9625 BABBA
	// DP
	int k;
	cin >> k;

	// 0 : A (1 0)
	// 1 : B (0 1)
	// 2 : BA (1 1)
	// 3 : BAB (1 2)
	// 4 : BABBA (2 3)
	// 5 : BABBABAB (3 5)
	// 피보나치 수열임을 알 수 있음

	int dp[46] = { 0 };
	dp[1] = 1;
	for (int i = 2; i <= k; ++i) dp[i] = dp[i - 1] + dp[i - 2];
	cout << dp[k - 1] << " " << dp[k];

	return 0;
}
