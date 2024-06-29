#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 17271 리그 오브 레전설 (Small)
	// DP
	int n, m;
	int dp[10001] = { 0 }; // 시간당 조합의 수
	dp[0] = 1; // dp[1] = 1 -> A, dp[2] = 2 -> AA, B
	cin >> n >> m;
	
	// 0부터 해야 B부터 시전하는 케이스도 생각할 수 있다
	for (int i = 0; i <= n; ++i) {
		// A 시전
		if (i + 1 <= n) {
			dp[i + 1] += dp[i];
			dp[i + 1] %= 1000000007;
		}
		// B 시전
		if (i + m <= n) {
			dp[i + m] += dp[i];
			dp[i + m] %= 1000000007;
		}
	}
	cout << dp[n];

	return 0;
}
