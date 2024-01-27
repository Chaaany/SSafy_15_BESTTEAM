#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 7579 앱
	// dp
	int n, m;
	int b[101] = { 0 };
	int c[101] = { 0 };

	// dp[i][j]는 i번째 앱까지 탐색할 때 j만큼의 cost를 냈을 때 확보할 수 있는 메모리
	// 앱은 최대 100개, 비용도 최대 100이므로 10001을 넘을 일은 없다
	int dp[101][10001] = { 0 };

	cin >> n >> m;

	// 입력받기
	for (int i = 1; i <= n; ++i) cin >> b[i];
	for (int i = 1; i <= n; ++i) cin >> c[i];

	// dp[i][j]
	for (int i = 1; i <= n; ++i) {
		for (int j = 0; j <= 10000; ++j) {
			if (j >= c[i]) dp[i][j] = max(dp[i][j], dp[i - 1][j - c[i]] + b[i]);
			dp[i][j] = max(dp[i][j], dp[i - 1][j]); // 같은 코스트로 바로 전 앱까지 확인했을 때 더 많은 메모리를 사용할 수도 있으니 이건 매번 체크
		}
	}

	// 최초에 등장한 친구가 정답 (0도 고려해야함)
	for (int i = 0; i <= 10000; ++i) {
		if (dp[n][i] >= m) {
			cout << i;
			break;
		}
	}

	return 0;
}
