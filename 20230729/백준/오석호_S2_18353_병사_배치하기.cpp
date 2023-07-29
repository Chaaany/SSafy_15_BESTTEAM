#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 18353 병사 배치하기
	// DP, LIS
	int n;
	int arr[2001] = { 0 };
	int dp[2001] = { 0 };
	int ans = 0;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> arr[i];
		dp[i] = 1;
	}

	for (int i = 1; i < n; ++i) {
		for (int j = 0; j < i; ++j) {
			if (arr[j] > arr[i]) dp[i] = max(dp[i], dp[j] + 1);
		}
	}
	
	// 정답출력
	for (int i = 0; i < n; ++i) ans = max(ans, dp[i]);
	cout << n - ans;

	return 0;
}
