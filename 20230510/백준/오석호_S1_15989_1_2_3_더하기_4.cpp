#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 15989 1,2,3 더하기 4
	// DP
	int t, n;
	long long dp[10001][4] = { 0 };
	cin >> t;
	// 전체 돌리기
	dp[1][1] = 1;
	dp[2][1] = 1;
	dp[2][2] = 1;
	dp[3][1] = 1;
	dp[3][2] = 1;
	dp[3][3] = 1;
	for (int i = 4; i <= 10000; ++i) {
		dp[i][1] = dp[i - 1][1]; // i-1에서는 1만 사용 가능
		dp[i][2] = dp[i - 2][1] + dp[i - 2][2]; // i-2에서는 1,2 사용가능
		dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3]; // i-3에서는 1,2,3 사용가능
	}
	while (t--) {
		cin >> n;
		cout << dp[n][1] + dp[n][2] + dp[n][3] << '\n';
	}

	return 0;
}
