#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 11060 점프 점프
	// DP
	int n;
	int arr[1001] = { 0 };
	int dp[1001] = { 0 }; // 해당 위치로 갈 수 있는 최단횟수를 담은 배열
	cin >> n;
	 
	// dp배열 초기화 (맨 처음 dp[0]은 무조건 0임)
	for (int i = 1; i < n; ++i) dp[i] = 1001;

	// 입력값 받기
	for (int i = 0; i < n; ++i) cin >> arr[i];

	// dp처리
	for (int i = 0; i < n; ++i) {
		for (int j = 1; j <= arr[i]; ++j) {
			if (i + j <= n) dp[i + j] = min(dp[i + j], dp[i] + 1);
		}
	}

	if (dp[n - 1] == 1001) cout << -1;
	else cout << dp[n - 1];

	return 0;
}
