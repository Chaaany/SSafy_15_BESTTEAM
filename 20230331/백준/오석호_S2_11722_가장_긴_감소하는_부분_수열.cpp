#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 11722 가장 긴 감소하는 부분 수열
	// DP
	int n;
	int ans = 0;
	cin >> n;
	int arr[1000] = { 0 };
	int dp[1000] = { 0 }; // 해당 위치에서 가장 긴 감소하는 부분수열을 
	for (int i = 0; i < n; ++i) {
		cin >> arr[i];
		dp[i] = 1;
		for (int j = 0; j < i; ++j) {
			// 앞에서부터 순서대로 비교해서 방금 입력받은 것보다 앞에 받은 입력값이 더 크면? 그 dp값에 + 1하거나, 현재 dp[i]값 유지하기
			if (arr[i] < arr[j]) dp[i] = max(dp[i], dp[j] + 1);
		}
		ans = max(ans, dp[i]);
	}
	cout << ans;

	return 0;
}
