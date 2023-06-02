#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1965 상자넣기
	// dp
	int n;
	int arr[1001] = { 0 };
	int dp[1001] = { 0 };
	int ans = 1;
	cin >> n;
	// arr배열 초기화
	for (int i = 0; i < n; ++i) cin >> arr[i];
	// dp배열 초기화 (자기 자신은 항상 넣을 수 있으므로)
	for (int i = 0; i < n; ++i) dp[i] = 1;
	// 상자 겹쳐넣기
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < i; ++j) {
			if (arr[i] > arr[j]) { // 이전 상자가 더 크면
				dp[i] = max(dp[i], dp[j] + 1); // 겹쳐넣고
				ans = max(ans, dp[i]); // 많이 겹쳐넣은걸 정답으로
			}
		}
	}
	cout << ans;

	return 0;
}
