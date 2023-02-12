#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 11066 파일 합치기
	// DP
	int sum[501] = { 0 };
	int file[501] = { 0 };
	int dp[501][501] = { 0 };

	int t;
	cin >> t;
	for (int tc = 0; tc < t; ++tc) {
		int k;
		cin >> k;
		// 초기 파일 등록
		for (int i = 1; i <= k; ++i) {
			cin >> file[i];
			sum[i] = sum[i - 1] + file[i];
		}
		// dp배열 생성
		for (int i = 1; i <= k; ++i) {
			for (int j = 1; j <= k - i; ++j) {
				dp[j][i + j] = 210000000;
				for (int a = j; a < i + j; ++a) {
					dp[j][i + j] = min(dp[j][i + j], dp[j][a] + dp[a + 1][i + j] + sum[i + j] - sum[j - 1]);
				}
			}
		}
		cout << dp[1][k] << '\n';
	}

	return 0;
}
