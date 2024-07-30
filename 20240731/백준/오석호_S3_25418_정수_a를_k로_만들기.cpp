#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 25418 정수 a를 k로 만들기
	// dp
	int a, k;
	int dp[1000001] = { 0 };
	cin >> a >> k;
	
	for (int i = a + 1; i <= k; ++i) {
		// +1 연산이라고 가정
		dp[i] = dp[i - 1] + 1;

		// 만약 나누어 떨어지고 a * 2가 i보다 작다면 *2 연산 가능 
		if (i % 2 == 0 && i / 2 >= a) dp[i] = min(dp[i], dp[i / 2] + 1);
	}

	cout << dp[k];

	return 0;
}
