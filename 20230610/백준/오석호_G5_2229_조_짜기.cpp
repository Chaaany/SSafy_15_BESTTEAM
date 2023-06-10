#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 2229 조 짜기
	// dp
	int n;
	int arr[1001] = { 0 };
	int dp[1001] = { 0 };
	cin >> n;
	for (int i = 0; i < n; ++i) cin >> arr[i];
	for (int i = 0; i < n; ++i) {
		int maxValue = arr[i];
		int minValue = arr[i];
		for (int j = i - 1; j >= 0; --j) {
			maxValue = max(maxValue, arr[j]);
			minValue = min(minValue, arr[j]);
			dp[i + 1] = max(dp[i + 1], dp[j] + maxValue - minValue);
		}
	}
	cout << dp[n];

	return 0;
}
