#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2718 타일 채우기
	// dp
	int t, n;
	int dp[101] = { 0, 1, 5, 11, 36, 0, };
	cin >> t;
	while (t--) {
		cin >> n;
		for (int i = 5; i <= n; ++i) dp[i] = dp[i - 1] + dp[i - 2] * 5 + dp[i - 3] - dp[i - 4] ;
		cout << dp[n] << '\n';
	}

	return 0;
}
