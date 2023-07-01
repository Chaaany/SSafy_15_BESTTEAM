#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 16112 5차 전직
	// 누적합, 그리디
	int n, k;
	long long arr[300001] = { 0 };
	long long dp[300001] = { 0 };
	long long ans = 0;
	cin >> n >> k;
	for (int i = 1; i <= n; ++i) cin >> arr[i];
	sort(arr, arr + n + 1);
	for (int i = 1; i <= n; ++i) dp[i] = dp[i - 1] + arr[i];

	for (int i = 1; i <= k; ++i) {
		ans += dp[n] - dp[i];
	}
	cout << ans;
	
	return 0;
}
