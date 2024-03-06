#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 8394 악수
	// DP
	int n;
	int ans = 0;
	int dp[10000001] = { 0 };
	cin >> n;
	
	// n = 1 이면 1가지, n = 2면 2가지 (악수 하거나 안하거나)
	// n = 3 이면 (), (1,2), (2,3) 3가지, n = 4는 예시처럼 5가지
	// n = 5면 (), (1,2), (2,3), (3,4), (4,5), (1,2 3,4), (1,2 4,5), (2,3 4,5) 8가지
	// -> 피보나치다
	dp[1] = 1;
	dp[2] = 2;
	for (int i = 3; i <= n; ++i) dp[i] = (dp[i - 1] + dp[i - 2]) % 10;

	cout << dp[n];

	return 0;
}
