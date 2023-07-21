#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 16194 카드 구매하기 2
	// DP
	int n; // 구매할 카드의 수
	int arr[1001] = { 0 };
	int dp[1001] = { 0 };
	cin >> n;

	// 입력값 받기
	for (int i = 1; i <= n; ++i) cin >> arr[i];

	// 최솟값으로 n개의 카드를 구매하는 경우의 수에 대한 dp 처리
	for (int i = 1; i <= n; ++i) {
		dp[i] = arr[i];
		// 이전 dp값을 기준으로 계산해보기 (모든 케이스중에서 최솟값을 구하면 됨
		// 4
		// 1 5 6 7 기준
		// 첫바퀴에는 1, 두번째 바퀴에는 dp[2](5)와 dp[1]+dp[1](2) 중 최솟값인 2 -> dp[2] = 2;
		// 세번째바퀴에는 dp[3](6), dp[2] + dp[1](3), dp[1] + dp[2](3) 중 최솟값인 3 -> dp[3] = 3;
		// 네번째바퀴에는 dp[4](7), dp[3] + dp[1](4), dp[2] + dp[2](4), dp[1] + dp[3](4) 중 최솟값인 4 -> dp[4] = 4;
		for (int j = 1; j < i; ++j) dp[i] = min(dp[i], dp[i - j] + dp[j]);
	}

	// 값 출력
	cout << dp[n];

	return 0;
}
